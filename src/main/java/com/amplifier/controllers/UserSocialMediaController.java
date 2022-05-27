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
@Api(value = "UserSocialMediaRestController", description = "REST controller related to User social media Entities")
public class UserSocialMediaController {

    @Autowired
    private UserSocialMediaService userSocialMediaService;

    @ApiOperation(value = "Find User Social Media by id number", notes = "Provide an id to lookup a specific user social media from the API", response = UserSocialMedia.class)
    @GetMapping(path = "/user/social-media?user_id={userId}&media_id={mediaId}")
    public @ResponseBody UserSocialMedia getUserSocialMediaById(@RequestParam(name = "media_id") int mediaId) {
        return userSocialMediaService.getById(mediaId);
    }

    @PostMapping("/user/social-media")
    @ApiOperation(value = "add new user social media entity")
    public @ResponseBody ClientMessage addUserSocialMedia(@RequestBody UserSocialMedia userSocialMedia) {
        return userSocialMediaService.add(userSocialMedia) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PutMapping("/user/social-media")
    @ApiOperation(value = "Update user social media entity")
    public @ResponseBody ClientMessage updateUserSocialMedia(@RequestBody UserSocialMedia userSocialMedia) {
        return userSocialMediaService.edit(userSocialMedia) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @DeleteMapping("/user/social-media")
    @ApiOperation(value = "Remove user social media entity")
    public @ResponseBody ClientMessage deleteUserSocialMedia(@RequestBody int id) {
        return userSocialMediaService.remove(id) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }

}
