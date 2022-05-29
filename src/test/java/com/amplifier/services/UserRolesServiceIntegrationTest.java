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

import com.amplifier.models.User;
import com.amplifier.models.UserBlizzardAccount;
import com.amplifier.models.UserRole;
import com.amplifier.models.UserSocialMedia;
import com.amplifier.repositories.UserRolesRepository;

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
public class UserRolesServiceIntegrationTest {

    @Autowired
    private static UserRolesRepository repository;

    @InjectMocks
    private static UserRolesServiceImpl service;

    private static UUID mockUUID1, mockUUID2;
    private static User mockUser1, mockUser2;
    private static UserSocialMedia mockSocialMedia1, mockSocialMedia2, mockSocialMedia3;
    private static UserBlizzardAccount mockAccount1, mockAccount2, mockAccount3;
    private static UserRole mockRole1, mockRole2, mockRole3;
    private static List<UserRole> dummyDb;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        LocalDate timestamp = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String joinDate = formatter.format(timestamp);

        mockAccount1 = new UserBlizzardAccount("Solsphere#1100");
        mockAccount2 = new UserBlizzardAccount("Patrickometry#1100");
        mockAccount3 = new UserBlizzardAccount("JMercado#1100");
        mockSocialMedia1 = new UserSocialMedia("www.solsphere.twitter.com", "www.solsphere.facebook.com",
                "www.solsphere.instagram.com");
        mockSocialMedia2 = new UserSocialMedia("www.patrickometry.twitter.com", "www.patrickometry.facebook.com",
                "www.patrickometry.instagram.com");
        mockSocialMedia3 = new UserSocialMedia("www.julian.twitter.com", "www.juian.facebook.com",
                "www.julian.instagram.com");
        mockRole1 = new UserRole("User");
        mockRole2 = new UserRole("Admin");

        /**
         * UUID Mocks
         */
        mockUUID1 = UUID.randomUUID();
        mockUUID2 = UUID.randomUUID();

        mockUser1 = new User(mockUUID1, "FullSol", "fullsol@gmail.com", "password",
                "Calvin", "Raines", mockAccount1, mockSocialMedia1,
                LocalDate.now(), mockRole1, true);
        mockUser2 = new User(mockUUID2, "Patrickometry", "patrick@gmail.com", "password", "Patrick", "Yaegar",
                mockAccount2,
                mockSocialMedia2,
                LocalDate.now(), mockRole2, true);

        dummyDb = new ArrayList<UserRole>();
        dummyDb.add(mockRole1);
        dummyDb.add(mockRole2);
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
    @DisplayName("2. Create UserRole Test")
    public void createUserRoleTest_success() {
        // Arrange
        mockRole3 = mockRole2;
        mockRole3.setId(3);

        // Action
        when(repository.save(mockRole3)).thenReturn(mockRole3);

        // Assert
        assertEquals(true, service.add(mockRole3));
    }

    @Test
    @Order(3)
    @DisplayName("3. Failed Creation UserRole Test")
    public void createUserRoleTest_fail() {
        // Arrange
        mockRole3 = new UserRole("Moderator");
        mockRole3.setId(3);

        // Action
        when(repository.save(mockRole3)).thenReturn(mockRole3);

        // Assert
        assertEquals(false, service.add(mockRole3));
    }

    @Test
    @Order(4)
    @DisplayName("4. Get UserRole based on ID Test")
    public void getByIdTest_success() {

        // Arrange
        Integer userRoleId = 1;

        // Action
        OngoingStubbing<UserRole> found = when(service.getById(userRoleId)).thenReturn(mockRole1);

        // Assert
        assertEquals(mockRole1, found);
    }

    @Test
    @Order(5)
    @DisplayName("5. Get all UserRoles Test")
    void getAllTest_success() {

        // Arrange - already completed

        // Action
        when(service.getAll()).thenReturn(dummyDb);

        // Assert
        assertEquals(dummyDb, service.getAll());
    }

    @Test
    @Order(6)
    @DisplayName("6. Update UserRole Test")
    void updateTest_success() {
        mockRole2.setUserRole("Member");

        when(service.getById(2)).thenReturn(mockRole2);
        when(repository.save(mockRole2)).thenReturn(mockRole2);

        assertEquals(true, service.edit(mockRole2));
    }

    @Test
    @Order(7)
    @DisplayName("7. Delete UserRole Test")
    void deleteTest_success() {
        doNothing().when(repository).delete(mockRole2);
        // act + assert step
        assertEquals(true, service.remove(mockRole2.getId()));
    }

}
