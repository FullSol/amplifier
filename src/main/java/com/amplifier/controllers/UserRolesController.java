package com.amplifier.controllers;

import static com.amplifier.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.CREATION_FAILED;
import static com.amplifier.util.ClientMessageUtil.UPDATE_FAILED;
import static com.amplifier.util.ClientMessageUtil.UPDATE_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.DELETION_FAILED;
import static com.amplifier.util.ClientMessageUtil.DELETION_SUCCESSFUL;

import java.util.List;

import com.amplifier.models.ClientMessage;
import com.amplifier.models.UserRole;
import com.amplifier.services.UserRolesService;

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
@Api (value = "UserRolesRestController", description = "REST controller related to UserRole Entities")
public class UserRolesController {

    @Autowired
    private UserRolesService userRolesService;

    @GetMapping("/roles")
    @ApiOperation(value = "Find all user roles.")
    public @ResponseBody List<UserRole> getAll(){
        return userRolesService.getAllUserRoles();
    }

    @ApiOperation(value = "Find user role by id number", notes = "Provide an id to lookup a specific user role from the API", response = UserRole.class)
    @GetMapping("/role?id={id}")
    public @ResponseBody UserRole getById(@RequestParam(value = "id")int id) {
        System.out.println("TEST: " + userRolesService.getUserRoleById(id));
        return userRolesService.getUserRoleById(id);
    }

    @PostMapping("/role")
    @ApiOperation(value = "Create new user role entity")
    public @ResponseBody ClientMessage createUserRole(@RequestBody UserRole userRole) {
        return userRolesService.addUserRole(userRole) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PutMapping("/role")
    @ApiOperation(value = "Update user role entity by id.")
    public @ResponseBody ClientMessage updateUserRole(@RequestBody UserRole userRole) {
        return userRolesService.editUserRole(userRole) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @DeleteMapping("/role")
    @ApiOperation(value = "Remove user role entity.")
    public @ResponseBody ClientMessage deleteUserRole(@RequestBody UserRole userRole) {
        return userRolesService.deleteUserRole(userRole) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }
}
