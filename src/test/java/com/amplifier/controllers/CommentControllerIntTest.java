package com.amplifier.controllers;

import static org.assertj.core.api.Assertions.assertThat;


import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.Comment;
import com.amplifier.models.User;
import com.amplifier.services.CommentService;
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
        CommentService userRolesService;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        mockComment1 = new Comment(1, "This is a comment.", 3, user, LocalDate.now());
        mockComment2 = new Comment(2, "This is another comment.", 6, user, LocalDate.now());

        mockCommentCreation = new Comment(3, "This is yet another comment.", 6, user, LocalDate.now());

        // mockRoleUpdation = mockRoleCreation;
        //mockRoleUpdation.setRoleName("Johnny");
        //mockRoleModification.setEmail("Johnny@gmail.com");
        // mockRoleDeletion = new UserRole();
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

 //test for find comment by id - pass 
    //test for find comment by id - fail
    //test for creating new comment - pass
    //test for creating new comment -fail
    //test for updating comment - pass
    //test for updating comment - fail
    //test for delete comment-pass
    //test for delete comment-fail
}
