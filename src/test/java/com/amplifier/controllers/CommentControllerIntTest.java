package com.amplifier.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.Comment;
import com.amplifier.models.User;
import com.amplifier.services.CommentService;
import com.amplifier.util.ClientMessageUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author Levi Choi
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(CommentController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommentControllerIntTest {
    private static Comment mockComment1;
    private static Comment mockComment2;
    private static Comment mockCommentCreation;
    private static Comment mockCommentUpdation;
    private static Comment mockCommentDeletion;
    private static List<Comment> mockDb;
    private static User user;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
                        MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    ObjectMapper om = new ObjectMapper();

    @Autowired
        CommentController commentController;

    @Autowired
        private MockMvc mockMvc;

    @MockBean
        CommentService commentService;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        mockComment1 = new Comment(1, "This is a comment.", 3, user, LocalDate.now());
        mockComment2 = new Comment(2, "This is another comment.", 6, user, LocalDate.now());

        mockCommentCreation = new Comment(3, "This is yet another comment.", 6, user, LocalDate.now());

        mockCommentUpdation = mockCommentCreation;
        mockCommentUpdation.setCommentText("I am editing this comment");
        //mockCommentDeletion = new Comment();
        mockDb = new ArrayList<>();
        mockDb.add(mockComment1);
        mockDb.add(mockComment2);
    }
    @Test
    @Order(1)
    @DisplayName("1. AppContext")
    public void contextLoads() {
            assertThat(commentController).isNotNull();
    }

    @Test
    @Order(2)
    @DisplayName("2. Attempt to pull all comments")
    public void getAllComments_Success() throws Exception {
            //CommentService method needs to be merged in.
            when(commentService.getAll()).thenReturn(mockDb);

            RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/comments");
            MvcResult result = mockMvc.perform(request).andReturn();

            assertEquals(om.writeValueAsString(mockDb), result.getResponse().getContentAsString());
    }

    @Test
    @Order(3)
    @DisplayName("3. Attempt to pull comment - failed.")
    public void getCommentById_Fail() throws Exception {

        //CommentService method needs to be merged in.
        when(commentService.getById(1)).thenReturn(mockComment1);

        RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/comment?id=1");
        MvcResult result = mockMvc.perform(request).andReturn();

        assertEquals(om.writeValueAsString(mockComment1), result.getResponse().getContentAsString());
    }

    @Test
    @Order(4)
    @DisplayName("4. Attempt to pull comment - passed.")
    public void getCommentById_Pass() throws Exception {
            //CommentService method needs to be merged in.
            when(commentService.getById(1)).thenReturn(mockComment1);

            //
            RequestBuilder request = MockMvcRequestBuilders
                            .get("/api/v1/comment?id=1");
            MvcResult result = mockMvc.perform(request).andReturn();

            assertEquals(om.writeValueAsString(mockComment1), result.getResponse().getContentAsString());
        }

    @Test
    @Order(5)
    @DisplayName("5. Attempt to create a new comment - failed.")
    public void postComment_Failed() throws Exception {
            //CommentService method needs to be merged in.
            when(commentService.add(mockCommentCreation)).thenReturn(true);

            RequestBuilder request = MockMvcRequestBuilders
                            .post("/api/v1/comment?id=3")
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                            .content(om.writeValueAsString(mockCommentCreation))
                            .contentType(MediaType.APPLICATION_JSON);

            //
            MvcResult result = mockMvc.perform(request).andReturn();
            assertEquals(om.writeValueAsString(ClientMessageUtil.CREATION_SUCCESSFUL),
                            result.getResponse().getContentAsString());
        }

    @Test
    @Order(6)
    @DisplayName("6. Attempt to create a new comment - passed.")
    public void postComment_Pass() throws Exception {
            //CommentService method needs to be merged in.
            when(commentService.add(mockCommentCreation)).thenReturn(true);

            RequestBuilder request = MockMvcRequestBuilders
                            .post("/api/v1/comment?id=3")
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                            .content(om.writeValueAsString(mockCommentCreation))
                            .contentType(MediaType.APPLICATION_JSON);

            MvcResult result = mockMvc.perform(request).andReturn();
            assertEquals(om.writeValueAsString(ClientMessageUtil.CREATION_SUCCESSFUL),
                            result.getResponse().getContentAsString());
    }

    @Test
    @Order(7)
    @DisplayName("7. Attempt to update comment - failed")
    public void updateComment_Failed() throws Exception {
            //CommentService method needs to be merged in.
            when(commentService.edit(mockCommentUpdation)).thenReturn(true);

            RequestBuilder request = MockMvcRequestBuilders
                            .put("/api/v1/comment?id=3")
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                            .content(om.writeValueAsString(mockCommentUpdation))
                            .contentType(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(request).andReturn();

            assertEquals(om.writeValueAsString(ClientMessageUtil.UPDATE_FAILED),
                            result.getResponse().getContentAsString());
        }

    @Test
    @Order(8)
    @DisplayName("8. Attempt to update comment - passed")
    public void updateComment_Passed() throws Exception {
            //CommentService method needs to be merged in.
            when(commentService.edit(mockCommentUpdation)).thenReturn(true);

            RequestBuilder request = MockMvcRequestBuilders
                            .put("/api/v1/comment?id=3")
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                            .content(om.writeValueAsString(mockCommentUpdation))
                            .contentType(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(request).andReturn();

            assertEquals(om.writeValueAsString(ClientMessageUtil.UPDATE_FAILED),
                            result.getResponse().getContentAsString());
        }

    @Test
    @Order(9)
    @DisplayName("9. Attempt to delete comment - failed")
    public void deleteComment_Failed() throws Exception {

        //CommentService method needs to be merged in.
        when(commentService.remove(mockComment1.getId())).thenReturn(true);

        RequestBuilder request = MockMvcRequestBuilders
                        .delete("/api/v1/comment?id=3")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(om.writeValueAsString(mockCommentDeletion))
                        .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andReturn();

        assertEquals(om.writeValueAsString(ClientMessageUtil.DELETION_FAILED),
                        result.getResponse().getContentAsString());
        }

    @Test
    @Order(10)
    @DisplayName("10. Attempt to delete comment - passed")
    public void deleteComment_Passed() throws Exception {

        //CommentService method needs to be merged in.
        when(commentService.remove(mockComment1.getId())).thenReturn(true);

        RequestBuilder request = MockMvcRequestBuilders
                        .delete("/api/v1/comment?id=3")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(om.writeValueAsString(mockCommentDeletion))
                        .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andReturn();

        assertEquals(om.writeValueAsString(ClientMessageUtil.DELETION_FAILED),
                        result.getResponse().getContentAsString());
        }
}
