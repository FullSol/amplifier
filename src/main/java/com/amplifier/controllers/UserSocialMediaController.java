package com.amplifier.controllers;

import static com.amplifier.util.ClientMessageUtil.CREATION_FAILED;
import static com.amplifier.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.DELETION_FAILED;
import static com.amplifier.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.UPDATE_FAILED;
import static com.amplifier.util.ClientMessageUtil.UPDATE_SUCCESSFUL;

import com.amplifier.models.ClientMessage;
import com.amplifier.models.UserSocialMedia;
import com.amplifier.services.UserSocialMediaService;

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
@Api(value = "UserSocialMediaRestController", description = "REST controller related to user social media entities")
public class UserSocialMediaController {

    @Autowired
    private UserSocialMediaService userSocialMediaService;

    @ApiOperation(value = "Find User Social Media by id number", notes = "Provide an id to lookup a specific user social media from the API", response = UserSocialMedia.class)
    @GetMapping(path = "/social-media")
    public @ResponseBody UserSocialMedia getUserSocialMediaById(@RequestParam(name = "user_id") String userId) {
        return userSocialMediaService.getByUserId(userId);
    }

    @PostMapping("/social-media")
    @ApiOperation(value = "Create new user's social media entity", notes = "Add a new user's social media information in the API.")
    public @ResponseBody ClientMessage addUserSocialMedia(@RequestParam(name = "user_id") String userId,
            @RequestBody UserSocialMedia userSocialMedia) {
        return userSocialMediaService.add(userId, userSocialMedia) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PatchMapping("/social-media")
    @ApiOperation(value = "Update user social media entity by ID.", notes = "Provide an id to update a specific user's social media information in the API.")
    public @ResponseBody ClientMessage updateUserSocialMedia(@RequestParam(name = "user_id") String userId,
            @RequestBody UserSocialMedia userSocialMedia) {
        return userSocialMediaService.edit(userId, userSocialMedia) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @DeleteMapping("/social-media")
    @ApiOperation(value = "Remove user social media entity by ID.", notes = "Provide an id to delete a user's social media information from the API")
    public @ResponseBody ClientMessage deleteUserSocialMedia(@RequestParam(name = "user_id") String userId) {
        return userSocialMediaService.remove(userId) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }

}
