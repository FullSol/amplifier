package com.amplifier.controllers;

import static com.amplifier.util.ClientMessageUtil.CREATION_FAILED;
import static com.amplifier.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.DELETION_FAILED;
import static com.amplifier.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.UPDATE_FAILED;
import static com.amplifier.util.ClientMessageUtil.UPDATE_SUCCESSFUL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amplifier.models.ClientMessage;
import com.amplifier.models.User;
import com.amplifier.models.UserJwtDTO;
import com.amplifier.services.JwtServiceImpl;
import com.amplifier.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.jsonwebtoken.security.InvalidKeyException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "UserCollection", description = "REST controller related to User Entities")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    JwtServiceImpl jwtService;

    @GetMapping(path = "/user")
    @ApiOperation(value = "Find user by id number", notes = "Provide an id to lookup a specific user from the API", response = User.class)
    public @ResponseBody User getById(@RequestHeader("Authorization") String authorization) {
        try {
            UserJwtDTO userDTO = jwtService.getDTO(authorization.replace("Bearer ", ""));

            if (userDTO != null) {
                return service.getById(userDTO.getId());
            } else {
                return null;
            }
        } catch (InvalidKeyException e) {
            return null;
        }
    }

    @GetMapping("/users")
    @ApiOperation(value = "Find all users", notes = "Provides a list of all users from the API.", response = User.class)
    public @ResponseBody List<User> getAll(@RequestHeader("Authorization") String authorization) {
        try {
            UserJwtDTO userDTO = jwtService.getDTO(authorization.replace("Bearer ", ""));

            if (userDTO != null && userDTO.getRole().getRole().equals("admin")) {
                return service.getAll();
            } else {
                return null;
            }
        } catch (InvalidKeyException e) {
            return null;
        }
    }

    @PostMapping("/user")
    @ApiOperation(value = "Create new user entity.", notes = "Adding a new user to the API.")
    public @ResponseBody ClientMessage register(@RequestBody User user) {
        return service.add(user) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PatchMapping("/user")
    @ApiOperation(value = "Update user entity by ID.", notes = "Provide an id to update a specific user profile in the API.")
    public @ResponseBody ClientMessage updateUser(@RequestHeader("Authorization") String authorization,
            @RequestBody User user) {
        try {
            UserJwtDTO userDTO = jwtService.getDTO(authorization.replace("Bearer ", ""));

            if (userDTO != null && userDTO.getRole().getRole().equals("admin")) {
                return service.edit(userDTO) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
            } else {
                return new ClientMessage("You are not authorized to perform this action.");
            }
        } catch (InvalidKeyException e) {
            return new ClientMessage(e.getMessage());
        }
        // return service.edit(userId, user) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @DeleteMapping("/user")
    @ApiOperation(value = "Remove user entity by ID.", notes = "Provide an id to delete a specific user from the API")
    public @ResponseBody ClientMessage deleteUser(@RequestHeader("Authorization") String authorization) {

        try {
            UserJwtDTO userDTO = jwtService.getDTO(authorization.replace("Bearer ", ""));

            if (userDTO != null && userDTO.getRole().getRole().equals("admin")) {
                return service.remove(userDTO.getId()) ? DELETION_SUCCESSFUL : DELETION_FAILED;
            } else {
                return new ClientMessage("You are not authorized to perform this action.");
            }
        } catch (InvalidKeyException e) {
            return new ClientMessage(e.getMessage());
        }
    }

    @CrossOrigin
    @PostMapping("/login")
    @ApiOperation(value = "Log user in, and return JWT", notes = "Adding a new user to the API.")
    public @ResponseBody ResponseEntity<String> login(@RequestBody User user) {
        HttpHeaders responseHeaders = new HttpHeaders();

        try {
            user = service.login(user);
        } catch (InvalidKeyException e) {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            String jwt = jwtService.createJwt(user);

            responseHeaders.set("X-Auth-Token",
                    "Bearer " + jwt);

        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body("Login Successful");
    }
}
