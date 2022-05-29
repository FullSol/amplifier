package com.amplifier.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.amplifier.models.ImgPost;
import com.amplifier.models.User;
import com.amplifier.models.UserBlizzardAccount;
import com.amplifier.models.UserRole;
import com.amplifier.models.UserSocialMedia;
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

    private static UUID uuid1, uuid2, uuid3;
    private static User user1, user2, user3;
    private static UserSocialMedia socialMedia1, socialMedia2, socialMedia3;
    private static UserBlizzardAccount mockAccount1, mockAccount2, mockAccount3;
    private static UserRole mockRole1, mockRole2;
    private static ImgPost imgPost1, imgPost2, imgPost3;
    private static List<ImgPost> dummyDb;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
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
         * UUIDs
         */
        uuid1 = UUID.randomUUID();
        uuid2 = UUID.randomUUID();
        uuid3 = UUID.randomUUID();

        /**
         * User Mocks
         */
        user1 = new User(uuid1, "FullSol", "fullsol@gmail.com", "password", "Calvin",
                "Raines", mockAccount1, socialMedia1,
                LocalDate.now(), mockRole1, true);

        user2 = new User(uuid2, "Patrickometry", "patrick@gmail.com", "password", "Patrick", "Yaegar", mockAccount2,
                socialMedia2,
                LocalDate.now(), mockRole2, true);

        user3 = new User(uuid3, "JulianMercado", "julianmercado@gmail.com", "password", "Julian", "Mercado",
                mockAccount3,
                socialMedia3,
                LocalDate.now(), mockRole2, true);

        /**
         * ImgPost Mocks
         */
        imgPost1 = new ImgPost("http://localhost:8080", user1);
        imgPost2 = new ImgPost("http://localhost:8081", user2);

        dummyDb = new ArrayList<ImgPost>();
        dummyDb.add(imgPost1);
        dummyDb.add(imgPost2);
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
        imgPost3 = imgPost2;
        imgPost3.setImgLocation("http://localhost:8083");

        // Action
        when(repository.save(imgPost3)).thenReturn(imgPost3);

        // Assert
        assertEquals(true, service.add(imgPost3));
    }

    @Test
    @Order(3)
    @DisplayName("3. Failed Creation ImgPost Test")
    public void createImgPostTest_fail() {
        // Arrange
        imgPost3 = imgPost2;
        imgPost3.setImgLocation("http://localhost:8083");

        // Action
        when(repository.save(imgPost3)).thenReturn(imgPost3);

        // Assert
        assertEquals(false, service.add(imgPost3));
    }

    @Test
    @Order(4)
    @DisplayName("4. Get ImgPost based on ID Test")
    public void getByIdTest_success() {

        // Arrange
        Integer imgPostId = 1;

        // Action
        OngoingStubbing<ImgPost> found = when(service.getById(imgPostId)).thenReturn(imgPost1);

        // Assert
        assertEquals(imgPost1, found);
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
        imgPost2.setImgLocation("http://localhost:8090");

        when(service.getById(2)).thenReturn(imgPost2);
        when(repository.save(imgPost2)).thenReturn(imgPost2);

        assertEquals(true, service.edit(imgPost2));
    }

    @Test
    @Order(8)
    @DisplayName("8. Delete ImgPost Test")
    void deleteTest_success() {
        doNothing().when(repository).delete(imgPost2);
        // act + assert step
        assertEquals(true, service.remove(imgPost2.getId()));
    }

}
