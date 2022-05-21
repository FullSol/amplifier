package com.amplifier.controllers;

import com.amplifier.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1")
@Api(value = "UserController", description = "REST controller related to User Entities")
public class UserController {

    @Autowired
    private UserService userService;

    // @ApiOperation(value="Find user by id number", notes="Provide an id to lookup
    // a specific user from the API", response = User.class)
    // @GetMapping(path = "/users", consumes = {MediaType.APPLICATION_JSON_VALUE})
    // public @ResponseBody User getById(@)

}
