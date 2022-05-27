package com.amplifier.controllers;

import static com.amplifier.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.CREATION_FAILED;
import static com.amplifier.util.ClientMessageUtil.UPDATE_FAILED;
import static com.amplifier.util.ClientMessageUtil.UPDATE_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.DELETION_FAILED;
import static com.amplifier.util.ClientMessageUtil.DELETION_SUCCESSFUL;

import com.amplifier.models.ClientMessage;
import com.amplifier.models.ImgPost;
import com.amplifier.services.ImgPostService;

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
@Api(value = "ImpPostController", description = "Controller for the Image Post")
public class ImgPostController {

    @Autowired
    private ImgPostService imgPostService;

    @ApiOperation(value = "Find User Social Media by id number", notes = "Provide an id to lookup a specific user social media from the API", response = ImgPost.class)
    @GetMapping(path = "/img-post?id={id}")
    public @ResponseBody ImgPost getById(
            @RequestParam(name = "id") int id) {
        return imgPostService.getById(id);
    }

    @PostMapping("/img-post")
    @ApiOperation(value = "add new image post entity")
    public @ResponseBody ClientMessage add(@RequestBody ImgPost imgPost) {
        return imgPostService.add(imgPost) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PutMapping("/img-post")
    @ApiOperation(value = "Update image post entity")
    public @ResponseBody ClientMessage update(@RequestBody ImgPost imgPost) {
        return imgPostService.edit(imgPost) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @DeleteMapping("/img-post?id={id}")
    @ApiOperation(value = "Remove image post entity")
    public @ResponseBody ClientMessage delete(@RequestParam(value = "id") int id) {
        return imgPostService.remove(id) ? DELETION_SUCCESSFUL
                : DELETION_FAILED;
    }

}
