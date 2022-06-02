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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "UserBlizzardAccountRestController", description = "REST controller related to User Blizzard Account Entities")
public class UserBlizzardAccountController {

    @Autowired
    private UserBlizzardAccountService service;

    @ApiOperation(value = "Find blizzard account by id number", notes = "Provide an id to lookup a specific blizzard account from the API", response = UserBlizzardAccount.class)
    @GetMapping(path = "/blizzard-account")
    public @ResponseBody UserBlizzardAccount getById(@RequestParam(name = "user_id") String userId) {
        return service.getByUserId(userId);
    }

    @PostMapping("/blizzard-account")
    @ApiOperation(value = "Create new blizzard account entity.", notes = "Adding a new blizzard account entitiy to the API.")
    public @ResponseBody ClientMessage createAccount(@RequestParam(name = "user_id") String userId,
            @RequestBody UserBlizzardAccount account) {
        return service.add(userId, account) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PatchMapping("/blizzard-account")
    @ApiOperation(value = "Update blizzard account entity by ID.", notes = "Provide an id to update a specific blizzard account in the API")
    public @ResponseBody ClientMessage updateAccount(@RequestParam(name = "user_id") String userId,
            @RequestBody UserBlizzardAccount account) {
        return service.edit(userId, account) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @DeleteMapping("/blizzard-account")
    @ApiOperation(value = "Remove blizzard account entity by ID.", notes = "Provide an id to remove a user's blizzard account in the API.")
    public @ResponseBody ClientMessage deleteAccount(@RequestBody UserBlizzardAccount account) {
        return service.remove(account.getBattleTag()) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }

}
