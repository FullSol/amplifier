package com.amplifier.controllers;

import com.amplifier.models.User;
import com.amplifier.services.UserBlizzardAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
public class UserBlizzardAccountController {

    @Autowired
    private UserBlizzardAccountService service;

    @ApiOperation(value = "Find user's blizzard account by id number", notes = "Provide an id to lookup a specific blizzard account from the API", response = User.class)
    @GetMapping(path = "/blizzard-controller")
    public @ResponseBody User getById(@RequestParam(value = "id", name = "id") int id) {

        return userService.getUserById(id);
    }
}
