package com.amplifier.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.Comment;
import com.amplifier.models.User;
import com.amplifier.repositories.CommentRepositoryImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

@ExtendWith(MockitoExtension.class)
public class CommentServiceImplIntTest {

    @TestConfiguration
    static class CommentServiceImplTestConfiguration {
        @Bean
        public CommentServiceImpl commentService() {
            return new CommentServiceImpl();
        }
    }

    private static User mockUser1;
    private static User mockUser2;
    private static User mockUser3;
    private static Comment mockComment1;
    private static Comment mockComment2;
    private static Comment mockCommentCreation;
    //private static Comment mockCommentUpdation;

    private static List<Comment> mockDb;

    @Autowired
    private CommentServiceImpl commentService;

    @MockBean
    private CommentRepositoryImpl commentRepository;

    @BeforeAll
    public void setup() {
        mockUser1 = new User(1, "L3viathon", "levi@gmail.com", "password", "Levi", "Choi", LocalDate.now());
        mockUser2 = new User(2, "MisterCalvin", "mistercalvin@gmail.com", "password", "Mister", "Calvin", LocalDate.now());
        mockUser3 = new User(3, "jmercado", "jmercado@gmail.com", "password", "Julian", "Mercado", LocalDate.now());
        mockComment1 = new Comment(1,"This is a comment", 1, mockUser1, LocalDate.now());
        mockComment2 = new Comment(2,"This is another comment", 2, mockUser2, LocalDate.now());

        mockCommentCreation = new Comment(3,"This is another comment on creating a comment", 3, mockUser3, LocalDate.now());

        // mockCommentUpdation = mockCommentCreation;

        // mockCommentUpdation.setCommentText("Fixing my comment");
        // mockCommentUpdation.setAuthor(mockUser3);

        mockDb = new ArrayList<>();
        mockDb.add(mockComment1);
        mockDb.add(mockComment2);
    }

    @Test
    @Order(1)
    @DisplayName("1. AppContext")
    public void contextLoads() {
        assertThat(commentService).isNotNull();
    }


}
