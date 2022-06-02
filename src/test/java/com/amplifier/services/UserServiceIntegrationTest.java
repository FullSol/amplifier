package com.amplifier.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.amplifier.models.User;
import com.amplifier.models.UserBlizzardAccount;
import com.amplifier.models.UserRole;
import com.amplifier.models.UserSocialMedia;
import com.amplifier.repositories.UserRepository;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceIntegrationTest {

    @Mock
    private static UserRepository repository;

    @InjectMocks
    private static UserServiceImpl service;

    private static UUID uuid1, uuid2, uuid3;
    private static User mockUser1, mockUser2, mockUser3;
    private static UserSocialMedia mockSocialMedia1, mockSocialMedia2, mockSocialMedia3;
    private static UserBlizzardAccount mockAccount1, mockAccount2, mockAccount3;
    private static UserRole mockRole1, mockRole2, mockRole3;
    private static List<User> mockDb;

    @BeforeAll
    static void setUp() throws Exception {
        repository = Mockito.mock(UserRepository.class);
        service = new UserServiceImpl(repository);

        LocalDate timestamp = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String joinDate = formatter.format(timestamp);

        // Blizzard Account Mocks
        mockAccount1 = new UserBlizzardAccount("Solsphere#1100");
        mockAccount2 = new UserBlizzardAccount("Patrickometry#1100");
        mockAccount3 = new UserBlizzardAccount("JMercado#1100");

        // Social Media Mocks
        mockSocialMedia1 = new UserSocialMedia("www.solsphere.twitter.com", "www.solsphere.facebook.com",
                "www.solsphere.instagram.com");
        mockSocialMedia2 = new UserSocialMedia("www.patrickometry.twitter.com", "www.patrickometry.facebook.com",
                "www.patrickometry.instagram.com");
        mockSocialMedia3 = new UserSocialMedia("www.julian.twitter.com", "www.juian.facebook.com",
                "www.julian.instagram.com");

        // User User mocks
        mockRole1 = new UserRole(1, "User");
        mockRole2 = new UserRole(2, "Admin");

        // UUID mocks
        uuid1 = UUID.randomUUID();
        uuid2 = UUID.randomUUID();
        uuid3 = UUID.randomUUID();

        // mock Users
        mockUser1 = new User(uuid1, "FullSol", "fullsol@gmail.com", "password",
                "Calvin", "Raines", mockAccount1, mockSocialMedia1,
                LocalDate.now(), mockRole1, true);
        mockUser2 = new User(uuid2, "Patrickometry", "patrick@gmail.com", "password", "Patrick", "Yaegar", mockAccount2,
                mockSocialMedia2,
                LocalDate.now(), mockRole2, true);

        // mockDb
        mockDb = new ArrayList<User>();
        mockDb.add(mockUser1);
        mockDb.add(mockUser2);
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
    @DisplayName("2. Register a new User Test - Pass")
    public void createUserTest_pass() {
        // Arrange
        mockUser3 = mockUser2;
        mockUser3.setId(uuid3);

        // Action
        when(repository.save(mockUser3)).thenReturn(mockUser3);

        // Assert
        assertEquals(true, service.add(mockUser3));
    }

    @Test
    @Order(3)
    @DisplayName("3. Register a new user test - fail")
    public void createUserTest_fail() {
        // Arrange
        mockUser3 = mockUser2;
        mockUser3.setId(uuid3);

        // Action
        when(repository.save(mockUser3)).thenReturn(mockUser3);

        // Assert
        assertEquals(true, service.add(mockUser3));
    }

    @Test
    @Order(4)
    @DisplayName("4. Get User by ID Test - pass")
    public void getByIdTest_pass() {

        // Arrange
        // Integer userRoleId = 1;

        // Action
        // OngoingStubbing<User> found =
        // when(service.getById(userId)).thenReturn(mockUser1);
        // when(repository.findById(uuid1)).thenReturn(mockUser1);

        // Assert
        // assertEquals(mockUser1, found);
        // assertEquals(mockUser1, service.getById(uuid1));
        // why is serviceimpl parameter set to string and not uuid?
    }

    @Test
    @Order(5)
    @DisplayName("5. Get all Users Test - pass")
    void getAllUsers_pass() {
        // Arrange - completed

        // Action
        when(service.getAll()).thenReturn(mockDb);

        // Assert
        assertEquals(mockDb, service.getAll());
    }

    @Test
    @Order(7)
    @DisplayName("7. Update User profile test - pass")
    void updateTest_pass() {
        mockUser2.setFirstName("Alahambra");
        // when(service.getById(uuid2)).thenReturn(mockUser2);
        // when(repository.save(mockRole2)).thenReturn(mockRole2);

        // assertEquals(true, service.edit(mockRole2));
    }

    @Test
    @Order(7)
    @DisplayName("7. Delete user profile test - pass")
    void deleteTest_pass() {
        // when(repository.delete(uuid2)).thenReturn(true);
        // act + assert step
        // assertEquals(true, service.remove(mockUser2.getId()));
    }

}
