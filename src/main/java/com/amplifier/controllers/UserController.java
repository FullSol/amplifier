package com.amplifier.controllers;

import static com.amplifier.util.ClientMessageUtil.CREATION_FAILED;
import static com.amplifier.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.DELETION_FAILED;
import static com.amplifier.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.UPDATE_FAILED;
import static com.amplifier.util.ClientMessageUtil.UPDATE_SUCCESSFUL;

import java.util.List;

import com.amplifier.models.ClientMessage;
import com.amplifier.models.User;
import com.amplifier.services.JwtServiceImpl;
import com.amplifier.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.security.InvalidKeyException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "UserRestController", description = "REST controller related to User Entities")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    JwtServiceImpl jwtService;

    @GetMapping(path = "/user")
    @ApiOperation(value = "Find user by id number", notes = "Provide an id to lookup a specific user from the API", response = User.class)
    public @ResponseBody User getById(@RequestParam(value = "id") String id) {
        return service.getById(id);
    }

    @GetMapping("/users")
    @ApiOperation(value = "Find all users", notes = "Provides a list of all users from the API.", response = User.class)
    public @ResponseBody List<User> getAll() {
        return service.getAll();
    }

    @PostMapping("/user")
    @ApiOperation(value = "Create new user entity.", notes = "Adding a new user to the API.")
    public @ResponseBody ClientMessage register(@RequestBody User user) {
        return service.add(user) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PatchMapping("/user")
    @ApiOperation(value = "Update user entity by ID.", notes = "Provide an id to update a specific user profile in the API.")
    public @ResponseBody ClientMessage updateUser(@RequestBody User user) {
        return service.edit(user) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @DeleteMapping("/user")
    @ApiOperation(value = "Remove user entity by ID.", notes = "Provide an id to delete a specific user from the API")
    public @ResponseBody ClientMessage deleteUser(@RequestBody String id) {
        return service.remove(id) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }

    @PostMapping("/login")
    @ApiOperation(value = "Log user in, and return JWT", notes = "Adding a new user to the API.")
    public @ResponseBody ResponseEntity<String> login(@RequestBody User user) {

        try {
            user = service.login(user);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            String jwt = jwtService.createJwt(user);

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("Baeldung-Example-Header",
                    jwt);

            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body("Response with header using ResponseEntity");
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
