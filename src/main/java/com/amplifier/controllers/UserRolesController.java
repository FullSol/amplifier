package com.amplifier.controllers;

import com.amplifier.services.UserRolesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1")
@Api(value = "UserRoleRestController", description = "REST controller related to User Role Entities")
public class UserRolesController {

    // @Autowired
    // private UserRolesService userRolesService;

}
