package com.amplifier.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.ImgPost;
import com.amplifier.models.User;
import com.amplifier.repositories.ImgPostRepository;

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
public class ImgPostServiceIntegrationTest {

    @Autowired
    private static ImgPostRepository repository;

    @InjectMocks
    private static ImgPostServiceImpl service;

    private static User mockUser1, mockUser2;
    private static ImgPost mockImgPost1, mockImgPost2, mockImgPost3;
    private static List<ImgPost> dummyDb;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        LocalDate timestamp = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String joinDate = formatter.format(timestamp);

        mockUser1 = new User("FullSol", "fullsol@gmail.com", "password", "Calvin", "Raines",
                LocalDate.now());
        mockUser2 = new User("L3viathon", "L3viathon@gmail.com", "password", "Levi", "Choi", LocalDate.now());

        mockImgPost1 = new ImgPost("http://localhost:8080", mockUser1);
        mockImgPost2 = new ImgPost("http://localhost:8081", mockUser2);

        dummyDb = new ArrayList<ImgPost>();
        dummyDb.add(mockImgPost1);
        dummyDb.add(mockImgPost1);
    }

    @Test
    @Order(1)
    @DisplayName("1. Mock Validation Test")
    public void checkMockInjection() {
        assertThat(repository).isNotNull();
        assertThat(service).isNotNull();
    }

    @Test
    @Order(2)
    @DisplayName("2. Create ImgPost Test")
    public void createImgPostTest_success() {
        // Arrange
        mockImgPost3 = mockImgPost2;
        mockImgPost3.setImgLocation("http://localhost:8083");

        // Action
        when(repository.save(mockImgPost3)).thenReturn(mockImgPost3);

        // Assert
        assertEquals(true, service.add(mockImgPost3));
    }

    @Test
    @Order(3)
    @DisplayName("3. Failed Creation ImgPost Test")
    public void createImgPostTest_fail() {
        // Arrange
        mockImgPost3 = mockImgPost2;
        mockImgPost3.setImgLocation("http://localhost:8083");

        // Action
        when(repository.save(mockImgPost3)).thenReturn(mockImgPost3);

        // Assert
        assertEquals(false, service.add(mockImgPost3));
    }

    @Test
    @Order(4)
    @DisplayName("4. Get ImgPost based on ID Test")
    public void getByIdTest_success() {

        // Arrange
        Integer imgPostId = 1;

        // Action
        OngoingStubbing<ImgPost> found = when(service.getById(imgPostId)).thenReturn(mockImgPost1);

        // Assert
        assertEquals(mockImgPost1, found);
    }

    @Test
    @Order(5)
    @DisplayName("5. Get all ImgPosts Test")
    void getAllTest_success() {

        // Arrange - already completed

        // Action
        when(service.getAll()).thenReturn(dummyDb);

        // Assert
        assertEquals(dummyDb, service.getAll());
    }

    @Test
    @Order(6)
    @DisplayName("6. Update ImgPost Test")
    void updateTest_success() {
        mockImgPost2.setImgLocation("http://localhost:8090");

        when(service.getById(2)).thenReturn(mockImgPost2);
        when(repository.save(mockImgPost2)).thenReturn(mockImgPost2);

        assertEquals(true, service.edit(mockImgPost2));
    }

    @Test
    @Order(8)
    @DisplayName("8. Delete ImgPost Test")
    void deleteTest_success() {
        doNothing().when(repository).delete(mockImgPost2);
        // act + assert step
        assertEquals(true, service.remove(mockImgPost2.getId()));
    }

}
 
