package com.amplifier.controllers;

import static com.amplifier.util.ClientMessageUtil.CREATION_FAILED;
import static com.amplifier.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.DELETION_FAILED;
import static com.amplifier.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.UPDATE_FAILED;
import static com.amplifier.util.ClientMessageUtil.UPDATE_SUCCESSFUL;

import java.util.List;

import com.amplifier.models.ClientMessage;
import com.amplifier.models.ImgPostComment;
import com.amplifier.services.ImgPostCommentServiceImpl;

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
@Api(value = "CommentRestController", description = "REST controller related to Comment Entities")
public class UserCommentController {

    @Autowired
    private ImgPostCommentServiceImpl service;

    @GetMapping("/comments")
    @ApiOperation(value = "Find all comments", notes = "Provides a list of all comments from the API", response = ImgPostComment.class)
    public @ResponseBody List<ImgPostComment> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "Find comment by id number", notes = "Provide an id to lookup a specific comment from the API", response = ImgPostComment.class)
    @GetMapping(path = "/comment")
    public @ResponseBody ImgPostComment getById(@RequestParam(name = "id") int id) {
        return service.getById(id);
    }

    @GetMapping(path = "/comment/author")
    @ApiOperation(value = "Find comment by id number", notes = "Provide an id to lookup a specific comment from the API", response = ImgPostComment.class)
    public @ResponseBody List<ImgPostComment> getByAuthorId(@RequestParam(name = "author_id") String authorId) {
        return service.getByAuthorId(authorId);
    }

    @ApiOperation(value = "Find comment by id number", notes = "Provide an id to lookup a specific comment from the API", response = ImgPostComment.class)
    @GetMapping(path = "/comment/post")
    public @ResponseBody List<ImgPostComment> getByImgPostId(@RequestParam(name = "img_post_id") int imgPostId) {
        return service.getByImagePostId(imgPostId);
    }

    @PostMapping("/comment")
    @ApiOperation(value = "Create new comment entity", notes = "Adding a new comment to the API.")
    public @ResponseBody ClientMessage addNewComment(@RequestParam(name = "post_id") int postId, @RequestBody ImgPostComment comment) {
        return service.add(postId, comment) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PatchMapping("/comment")
    @ApiOperation(value = "Update comment entity by ID", notes = "Provide an id to editing a specific comment through the API.")
    public @ResponseBody ClientMessage edit(@RequestParam(value = "id") int id, @RequestBody ImgPostComment comment) {
        return service.edit(id, comment) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @DeleteMapping("/comment")
    @ApiOperation(value = "Remove user entity by ID", notes = "Provide an id to delete a specific comment in the API.")
    public @ResponseBody ClientMessage delete(@RequestParam(value = "id") int id) {
        return service.remove(service.getById(id)) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }

}
