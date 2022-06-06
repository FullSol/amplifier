package com.amplifier.controllers;

import static com.amplifier.util.ClientMessageUtil.CREATION_FAILED;
import static com.amplifier.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.DELETION_FAILED;
import static com.amplifier.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.UPDATE_FAILED;
import static com.amplifier.util.ClientMessageUtil.UPDATE_SUCCESSFUL;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.amplifier.models.ImgPostComment;
import com.amplifier.models.User;
import com.amplifier.models.UserJwtDTO;
import com.amplifier.services.ImgPostCommentServiceImpl;
import com.amplifier.services.ImgPostServiceImpl;
import com.amplifier.services.JwtServiceImpl;
import com.amplifier.services.UserServiceImpl;

import io.jsonwebtoken.security.InvalidKeyException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/v1")
@Api(value = "CommentRestController", description = "REST controller related to Comment Entities")
public class UserCommentController {

    @Autowired
    private ImgPostCommentServiceImpl service;

    @Autowired
    JwtServiceImpl jwtService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ImgPostServiceImpl imgPostService;

    private static Logger logger = Logger.getLogger(UserCommentController.class);

    @ApiOperation(value = "Find comment by id number", notes = "Provide an id to lookup a specific comment from the API", response = ImgPostComment.class)
    @GetMapping(path = "/comment")
    public @ResponseBody ImgPostComment getById(@RequestParam(name = "id") int id) {
        return service.getById(id);
    }

    @GetMapping(path = "/comments/author")
    @ApiOperation(value = "Find all comments by Author Id.", notes = "Provide an id to lookup a specific comment from the API", response = ImgPostComment.class)
    public @ResponseBody List<ImgPostComment> getByAuthorId(@RequestParam(name = "author_id") String authorId) {
        return service.getByAuthorId(authorId);
    }

    @ApiOperation(value = "Find all comments by Image Post Id.", notes = "Provide an id to lookup a specific comment from the API", response = ImgPostComment.class)
    @GetMapping(path = "/comments/post")
    public @ResponseBody List<ImgPostComment> getByImgPostId(@RequestParam(name = "post_id") int imgPostId) {
        return service.getByImagePostId(imgPostId);
    }

    @PostMapping("/comment")
    @ApiOperation(value = "Create new comment entity", notes = "Adding a new comment to the API.")
    public ClientMessage addNewComment(@RequestHeader String authorization, @RequestParam(name = "post_id") int postId,
            @RequestBody ImgPostComment comment) {
        try {
            UserJwtDTO userDTO = jwtService.getDTO(authorization.replace("Bearer ", ""));
            logger.debug(userDTO);
            if (userDTO != null) {
                User user = userService.getById(userDTO.getId());
                ImgPost imgPost = imgPostService.getById(postId);
                comment.setAuthor(user);
                comment.setImgPost(imgPost);
                return service.add(comment) ? CREATION_SUCCESSFUL : CREATION_FAILED;
            } else {
                return null;
            }
        } catch (InvalidKeyException e) {
            return null;
        }

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
