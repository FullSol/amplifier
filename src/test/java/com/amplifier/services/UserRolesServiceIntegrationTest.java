package com.amplifier.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.UserRole;
import com.amplifier.repositories.UserRolesRepository;

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
public class UserRolesServiceIntegrationTest {

    @Mock
    private static UserRolesRepository repository;

    @InjectMocks
    private static UserRolesServiceImpl service;

    private static UserRole mockRole1, mockRole2, mockRole3;
    private static List<UserRole> dummyDb;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        repository = Mockito.mock(UserRolesRepository.class);
        service = new UserRolesServiceImpl(repository);

        /**
         * User Role Mocks
         */
        mockRole1 = new UserRole(1, "User");
        mockRole2 = new UserRole(2, "Admin");

        /**
         * MockDB
         */
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
        // Integer userRoleId = 1;

        // Action
        // OngoingStubbing<UserRole> found = when(service.getById(userRoleId)).thenReturn(mockRole1);
        when(repository.findById(1)).thenReturn(mockRole1);

        // Assert
        //assertEquals(mockRole1, found);
        assertEquals(mockRole1, service.getById(1));
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
        //doNothing().when(repository).delete(2);
        //doNothing() is used when you are using a void method.
        when(repository.delete(2)).thenReturn(true);
        // act + assert step
        assertEquals(true, service.remove(mockRole2.getId()));
    }

}
