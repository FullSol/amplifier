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
import com.amplifier.models.UserBlizzardAccount;
import com.amplifier.services.UserBlizzardAccountService;

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

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
public class UserBlizzardAccountController {

    @Autowired
    private UserBlizzardAccountService service;

    @ApiOperation(value = "Find user's blizzard account by id number", notes = "Provide an id to lookup a specific blizzard account from the API", response = User.class)
    @GetMapping(path = "/blizzard-account?id={id}")
    public @ResponseBody UserBlizzardAccount getById(@RequestParam(value = "id", name = "id") int id) {
        return service.getById(id);
    }

    @GetMapping("/blizzard-account")
    @ApiOperation(value = "Find all users' blizzard accounts")
    public @ResponseBody List<UserBlizzardAccount> getAll() {
        return service.getAll();
    }

    @PostMapping("/blizzard-account")
    @ApiOperation(value = "Create new user's blizzard account entity")
    public @ResponseBody ClientMessage createAccount(@RequestBody UserBlizzardAccount account) {
        return service.add(account) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PatchMapping("/blizzard-account")
    @ApiOperation(value = "Update user's blizzard account entity")
    public @ResponseBody ClientMessage updateAccount(@RequestBody UserBlizzardAccount account) {
        return service.edit(account) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @DeleteMapping("/blizzard-account")
    @ApiOperation(value = "Remove user's blizzard account entity")
    public @ResponseBody ClientMessage deleteAccount(@RequestBody UserBlizzardAccount account) {
        return service.remove(account.getId()) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }

}
