package com.amplifier.controllers;

import java.util.List;

import com.amplifier.models.User;
import com.amplifier.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @ApiOperation(value = "Find user by id number", notes = "Retrieve all users from the API")
    @GetMapping(path = "/users", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody List<User> users() {
        return userService.getAll();
    }

}
