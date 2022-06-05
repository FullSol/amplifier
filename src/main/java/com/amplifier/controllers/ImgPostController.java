package com.amplifier.controllers;

import static com.amplifier.util.ClientMessageUtil.DELETION_FAILED;
import static com.amplifier.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.UPDATE_FAILED;
import static com.amplifier.util.ClientMessageUtil.UPDATE_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.CREATION_FAILED;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amplifier.models.ClientMessage;
import com.amplifier.models.ImgPost;
import com.amplifier.models.UserJwtDTO;
import com.amplifier.services.ImgPostServiceImpl;
import com.amplifier.services.JwtServiceImpl;

import io.jsonwebtoken.security.InvalidKeyException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "ImpPostController", description = "REST Controller related to Image Post entities.")
public class ImgPostController {

    @Autowired
    private ImgPostServiceImpl imgPostService;

    @Autowired
    JwtServiceImpl jwtService;

    @GetMapping("/img-posts")
    @ApiOperation(value = "Find all image posts", notes = "Provides a list of all image posts from the API", response = ImgPost.class)
    public @ResponseBody List<ImgPost> getAll() {
        return imgPostService.getAll();
    }

    @GetMapping(path = "/img-post")
    @ApiOperation(value = "Find image post by id number", notes = "Provide an id to lookup a specific user's image post from the API", response = ImgPost.class)
    public @ResponseBody ImgPost getById(@RequestParam(name = "id") int id) throws Exception {
        return imgPostService.getById(id);
    }

    @PostMapping("/img-post")
    @ApiOperation(value = "Add a new image post entity.", notes = "Adding a new image post to the API.")
    public @ResponseBody ClientMessage add(@RequestHeader("Authorization") String authorization,
            @RequestBody ImgPost imgPost) {
        try {
            UserJwtDTO userDTO = jwtService.getDTO(authorization.replace("Bearer ", ""));

            if (userDTO != null) {
                return imgPostService.add(userDTO, imgPost) ? CREATION_SUCCESSFUL : CREATION_FAILED;
            } else {
                return null;
            }
        } catch (InvalidKeyException e) {
            return null;
        }
    }

    @PatchMapping("/img-post")
    @ApiOperation(value = "Update image post entity by ID.", notes = "Provide an id to update a specific image post in the API.")
    public @ResponseBody ClientMessage update(@RequestParam(value = "id") int id, @RequestBody ImgPost imgPost) {
        return imgPostService.edit(id, imgPost) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @DeleteMapping("/img-post")
    @ApiOperation(value = "Remove image post entity by ID.", notes = "Provide an id to delete a specific image post in the API.")
    public @ResponseBody ClientMessage deleteComment(@RequestParam(value = "id") int id) {
        return imgPostService.remove(imgPostService.getById(id)) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }

}
