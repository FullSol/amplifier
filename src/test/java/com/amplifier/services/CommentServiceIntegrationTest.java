package com.amplifier.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.Comment;
import com.amplifier.models.User;
import com.amplifier.models.UserBlizzardAccount;
import com.amplifier.models.UserRole;
import com.amplifier.models.UserSocialMedia;
import com.amplifier.repositories.CommentRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommentServiceIntegrationTest {

    @Autowired
    private static CommentRepository commentRepository;

    @InjectMocks
    private static CommentServiceImpl commentService; // needs be merged in...

    private static User user1, user2, user3;
    private static UserSocialMedia socialMedia1, socialMedia2, socialMedia3;
    private static UserBlizzardAccount mockAccount1, mockAccount2, mockAccount3;
    private static Comment comment1, comment2, comment3;
    private static UserRole mockRole1, mockRole2;
    private static List<Comment> mockDb;

    @BeforeAll
    static void setUp() throws Exception {
        LocalDate timestamp = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String joinDate = formatter.format(timestamp);

        /**
         * Social Media Mocks
         */
        socialMedia1 = new UserSocialMedia("www.solsphere.twitter.com", "www.solsphere.facebook.com",
                "www.solsphere.instagram.com");

        socialMedia2 = new UserSocialMedia("www.patrickometry.twitter.com", "www.patrickometry.facebook.com",
                "www.patrickometry.instagram.com");

        socialMedia3 = new UserSocialMedia("www.julian.twitter.com", "www.juian.facebook.com",
                "www.julian.instagram.com");

        /**
         * User Roles Mocks
         */
        mockRole1 = new UserRole("User");

        mockRole2 = new UserRole("Admin");

        /**
         * User Mocks
         */
        user1 = new User("8e4ac3a8-ae4a-4ea1-85a8-9d9d1bff8f60", "FullSol", "fullsol@gmail.com", "password", "Calvin",
                "Raines", mockAccount1, socialMedia1,
                LocalDate.now(), mockRole1, true);

        user2 = new User("Patrickometry", "patrick@gmail.com", "password", "Patrick", "Yaegar", mockAccount2,
                socialMedia2,
                LocalDate.now(), mockRole2, true);

        user3 = new User("JulianMercado", "julianmercado@gmail.com", "password", "Julian", "Mercado", mockAccount3,
                socialMedia3,
                LocalDate.now(), mockRole2, true);

        /**
         * Comment Mocks
         */
        comment1 = new Comment(1, "This is a comment", 1, user1, LocalDate.now());

        comment2 = new Comment(2, "This is another comment", 2, user2, LocalDate.now());

        mockDb = new ArrayList<>();
        mockDb.add(comment1);
        mockDb.add(comment2);
    }

    @Test
    @Order(1)
    @DisplayName("1. Mock Validation Test")
    public void checkMockInjection() {
        assertThat(commentRepository).isNotNull();
        assertThat(commentService).isNotNull(); // error, commentService needs to be merged in.
    }

    @Test
    @Order(3)
    @DisplayName("3. Attempt to create comment - fail")
    public void createComment_fail() {

        comment3 = new Comment(3, "This is a whole new comment", 3, user3, LocalDate.now());

        when(commentRepository.save(comment3)).thenReturn(comment3); // save method won't work until commentRepo
                                                                     // merged.

        // Assert
        assertEquals(false, commentService.add(comment3));
    }

    // Test for creating - pass?

    @Test
    @Order(4)
    @DisplayName("4. Attempt to retrieve comment by Id - pass")
    public void getCommentById_pass() {

        Integer commentId = 1;

        OngoingStubbing<Comment> found = when(commentService.getById(commentId)).thenReturn(comment1);

        assertEquals(comment1, found);
    }

    // getById fail?

    @Test
    @Order(5)
    @DisplayName("5. Attempt to retrieve all comments - pass.")
    void getAllComments_pass() {

        // Arrange - already completed

        // Behavior
        when(commentService.getAll()).thenReturn(mockDb);

        // Action & Assert
        assertEquals(mockDb, commentService.getAll());
    }

    @Test
    @Order(6)
    @DisplayName("6. Attempt to update comment - pass")
    void updateComment_pass() {
        comment2.setCommentText("This is an updated comment.");

        when(commentService.getById(2)).thenReturn(comment2);
        when(commentRepository.save(comment2)).thenReturn(comment2);

        assertEquals(true, commentService.edit(comment2));
    }

    // update Comment fail?

    @Test
    @Order(8)
    @DisplayName("8. Attempt to delete comment - pass.")
    void deleteComment_pass() {
        doNothing().when(commentRepository).delete(comment2); // delete method needs to be updated in
                                                              // commentRepository

        assertEquals(true, commentService.remove(comment2.getId()));
    }

    // delete comment fail?

}
