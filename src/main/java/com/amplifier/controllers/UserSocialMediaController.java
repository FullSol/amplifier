package com.amplifier.controllers;

import java.util.List;

import static com.amplifier.util.ClientMessageUtil.*;

import com.amplifier.models.ClientMessage;
import com.amplifier.models.User;
import com.amplifier.services.UserService;

import com.amplifier.services.UserSocialMediaService;
import com.amplifier.models.UserSocialMedia;

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
    @GetMapping(path = "/user/user_id/social-media/media_id")
    public @ResponseBody UserSocialMedia getUserSocialMediaById(@RequestParam(value = "id", name = "media_id") int id) {
        return userSocialMediaService.getUserSocialMediaById(id);
    }

    @PostMapping("/user/user_id/social-media")
    @ApiOperation(value = "add new user social media entity")
    public @ResponseBody ClientMessage addUserSocialMedia(@RequestBody UserSocialMedia userSocialMedia) {
        return userSocialMediaService.addUserSocialMedia(userSocialMedia) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PutMapping("/user/user_id/social-media")
    @ApiOperation(value = "Update user social media entity")
    public @ResponseBody ClientMessage updateUserSocialMedia(@RequestBody UserSocialMedia userSocialMedia) {
        return userSocialMediaService.updateUser(userSocialMedia) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @DeleteMapping("/user/user_id/social-media")
    @ApiOperation(value = "Remove user social media entity")
    public @ResponseBody ClientMessage deleteUserSocialMedia(@RequestBody UserSocialMedia userSocialMedia) {
        return userSocialMediaService.deleteUserSocialMedia(userSocialMedia) ? DELETION_SUCCESSFUL
                : DELETION_FAILED;
    }

}
