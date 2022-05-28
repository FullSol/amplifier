package com.amplifier.controllers;

import static com.amplifier.util.ClientMessageUtil.CREATION_FAILED;
import static com.amplifier.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.DELETION_FAILED;
import static com.amplifier.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.UPDATE_FAILED;
import static com.amplifier.util.ClientMessageUtil.UPDATE_SUCCESSFUL;

import java.util.List;

import com.amplifier.models.ClientMessage;
import com.amplifier.models.Comment;
import com.amplifier.services.CommentService;

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
public class CommentController {

    @Autowired
    private CommentService service;

    @ApiOperation(value = "Find comment by id number", notes = "Provide an id to lookup a specific comment from the API", response = Comment.class)
    @GetMapping(path = "/comment?id={id}")
    public @ResponseBody Comment getById(@RequestParam(name = "id") int id) {
        return service.getById(id);
    }

    @GetMapping("/comments")
    @ApiOperation(value = "Find all comments", notes = "Pulling all comments from the API", response = Comment.class)
    public @ResponseBody List<Comment> getAll() {
        return service.getAll();
    }

    @PostMapping("/comment")
    @ApiOperation(value = "Create new comment entity", notes = "Adding a new comment through the API")
    public @ResponseBody ClientMessage add(@RequestBody Comment comment) {
        return service.add(comment) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PatchMapping("/comment")
    @ApiOperation(value = "Update comment entity", notes = "Editing a comment through the API")
    public @ResponseBody ClientMessage edi(@RequestBody Comment comment) {
        return service.edit(comment) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @DeleteMapping("/comment?id={id}")
    @ApiOperation(value = "Remove user entity", notes = "Deleting a comment through the API")
    public @ResponseBody ClientMessage delete(@RequestParam(value = "id") int id) {
        return service.remove(id) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }

}
