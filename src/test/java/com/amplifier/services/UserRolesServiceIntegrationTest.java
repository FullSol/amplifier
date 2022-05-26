package com.amplifier.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.User;
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

    private static User mockUser1, mockUser2;
    private static UserRole mockUserRole1, mockUserRole2, mockUserRole3;
    private static List<UserRole> dummyDb;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        LocalDate timestamp = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String joinDate = formatter.format(timestamp);

        mockUser1 = new User("Patrickster", "patrickster@gmail.com", "password", "Patrick", "Trickster", LocalDate.now());
        mockUser2 = new User("Levitate", "levitate@gmail.com", "password", "Lee", "Tate", LocalDate.now());

        mockUserRole1 = new UserRole(1, mockUser1);
        mockUserRole2 = new UserRole(2, mockUser2);

        dummyDb = new ArrayList<UserRole>();
        dummyDb.add(mockUserRole1);
        dummyDb.add(mockUserRole2);
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
        mockUserRole3 = mockUserRole2;
        mockUserRole3.setId(3);

        // Action
        when(repository.save(mockUserRole3)).thenReturn(mockUserRole3);

        // Assert
        assertEquals(true, service.add(mockUserRole3));
    }


    @Test
    @Order(3)
    @DisplayName("3. Failed Creation UserRole Test")
    public void createUserRoleTest_fail() {
        // Arrange
        mockUserRole3 = mockUserRole2;
        mockUserRole3.setId(3);

        // Action
        when(repository.save(mockUserRole3)).thenReturn(mockUserRole3);

        // Assert
        assertEquals(false, service.add(mockUserRole3));
    }


    @Test
    @Order(4)
    @DisplayName("4. Get UserRole based on ID Test")
    public void getByIdTest_success() {

        // Arrange
        Integer userRoleId = 1;

        // Action
        OngoingStubbing<UserRole> found = when(service.getById(userRoleId)).thenReturn(mockUserRole1);

        // Assert
        assertEquals(mockUserRole1, found);
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
        mockUserRole2.setUserRole("Member");

        when(service.getById(2)).thenReturn(mockUserRole2);
        when(repository.save(mockUserRole2)).thenReturn(mockUserRole2);

        assertEquals(true, service.edit(mockUserRole2));
    }    
    
    @Test
    @Order(7)
    @DisplayName("7. Delete UserRole Test")
    void deleteTest_success() {
        doNothing().when(repository).delete(mockUserRole2);
        // act + assert step
        assertEquals(true, service.remove(mockUserRole2.getId()));
    }    


}
