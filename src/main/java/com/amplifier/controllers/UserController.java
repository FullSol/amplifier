package com.amplifier.controllers;

import java.util.List;

import com.amplifier.models.ClientMessage;
import com.amplifier.models.User;
import com.amplifier.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "UserRestController", description = "REST controller related to User Entities")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Find user by id number", notes = "Provide an id to lookup a specific user from the API", response = User.class)
    @GetMapping(path = "/user")
    public @ResponseBody User getById(@RequestParam(value = "id", name = "id") int id) {
        System.out.println("TEST: " + userService.getUserById(id));
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    @ApiOperation(value = "Find all users")
    public @ResponseBody List<User> getAll() {
        return userService.getAllUsers();
    }
}
