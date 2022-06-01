package com.amplifier.controllers;

import static com.amplifier.util.ClientMessageUtil.CREATION_FAILED;
import static com.amplifier.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.DELETION_FAILED;
import static com.amplifier.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.UPDATE_FAILED;
import static com.amplifier.util.ClientMessageUtil.UPDATE_SUCCESSFUL;

import java.util.List;

import com.amplifier.models.ClientMessage;
import com.amplifier.models.UserRole;
import com.amplifier.services.UserRolesServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Users", description = "REST controller related to UserRole Entities")
public class UserRolesController {

    @Autowired
    private UserRolesServiceImpl service;

    @GetMapping("/roles")
    @ApiOperation(value = "Find all user roles.", notes = "Provides a list of all user roles from the API", response = UserRole.class)
    public @ResponseBody List<UserRole> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "Find user role by id number", notes = "Provide an id to lookup a specific user role from the API", response = UserRole.class)
    @GetMapping("/role")
    public @ResponseBody UserRole getById(@RequestParam(value = "id") int id) {
        return service.getById(id);
    }

    @PostMapping(path = "/role")
    @ApiOperation(value = "Create new user role entity", notes = "Add a new user role in the API.")
    public @ResponseBody ClientMessage createUserRole(@RequestBody UserRole userRole) throws Exception {
        return service.add(userRole) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PatchMapping("/role")
    @ApiOperation(value = "Update user role entity by id.", notes = "Provide an id to update a specific user role in the API.")
    public @ResponseBody ClientMessage updateUserRole(@RequestParam(name= "id") int id, @RequestBody UserRole userRole) {
        return service.edit(id, userRole) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @DeleteMapping("/role")
    @ApiOperation(value = "Remove user role entity by ID.", notes = "Provide an id to remove a specific user role from the API")
    public @ResponseBody ClientMessage deleteUserRole(@RequestParam(name = "id") int id) {
        return service.remove(id) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }
}
