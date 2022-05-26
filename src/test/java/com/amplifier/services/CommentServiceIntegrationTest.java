package com.amplifier.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.Comment;
import com.amplifier.models.User;
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
    private static CommentServiceImpl commentService;  //needs be merged in...

    private static User mockUser1, mockUser2, mockUser3;
    private static Comment mockComment1, mockComment2, mockComment3;
    private static List<Comment> mockDb;

    @BeforeAll
    static void setUp() throws Exception {
        LocalDate timestamp = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String joinDate = formatter.format(timestamp);

        mockUser1 = new User("L3viathon", "levi@gmail.com", "password", "Levi", "Choi", LocalDate.now());
        mockUser2 = new User("MisterCalvin", "mistercalvin@gmail.com", "password", "Mister", "Calvin", LocalDate.now());
        mockUser3 = new User("jmercado", "jmercado@gmail.com", "password", "Julian", "Mercado", LocalDate.now());
        mockComment1 = new Comment(1,"This is a comment", 1, mockUser1, LocalDate.now());
        mockComment2 = new Comment(2,"This is another comment", 2, mockUser2, LocalDate.now());

        mockDb = new ArrayList<>();
        mockDb.add(mockComment1);
        mockDb.add(mockComment2);
    }

    @Test
    @Order(1)
    @DisplayName("1. Mock Validation Test")
    public void checkMockInjection() {
        assertThat(commentRepository).isNotNull();
        assertThat(commentService).isNotNull();     //error, commentService needs to be merged in.
    }


    @Test
    @Order(3)
    @DisplayName("3. Attempt to create comment - fail")
    public void createComment_fail() {

        mockComment3 = new Comment(3,"This is a whole new comment", 3, mockUser3, LocalDate.now());

        when(commentRepository.save(mockComment3)).thenReturn(mockComment3); //save method won't work until commentRepo merged.

        // Assert
        assertEquals(false, commentService.add(mockComment3));
    }

    //Test for creating - pass?

    @Test
    @Order(4)
    @DisplayName("4. Attempt to retrieve comment by Id - pass")
    public void getCommentById_pass() {

        Integer commentId = 1;

        OngoingStubbing<Comment> found = when(commentService.getById(commentId)).thenReturn(mockComment1);

        assertEquals(mockComment1, found);
    }

    //getById fail?

    @Test
    @Order(5)
    @DisplayName("5. Attempt to retrieve all comments - pass.")
    void getAllComments_pass() {

        // Arrange - already completed

        when(commentService.getAll()).thenReturn(mockDb);

        assertEquals(mockDb, commentService.getAll());
    }

    @Test
    @Order(6)
    @DisplayName("6. Attempt to update comment - pass")
    void updateComment_pass() {
        mockComment2.setCommentText("This is an updated comment.");

        when(commentService.getById(2)).thenReturn(mockComment2);
        when(commentRepository.save(mockComment2)).thenReturn(mockComment2);

        assertEquals(true, commentService.edit(mockComment2));
    }

    //update Comment fail?

    @Test
    @Order(8)
    @DisplayName("8. Attempt to delete comment - pass.")
    void deleteComment_pass() {
        doNothing().when(commentRepository).delete(mockComment2); //delete method needs to be updated in commentRepository

        assertEquals(true, commentService.remove(mockComment2.getId()));
    }

    //delete comment fail?

}
