package com.amplifier.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.User;
import com.amplifier.services.UserServiceImpl;
import com.amplifier.util.ClientMessageUtil;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerIntTest {

    private static User mockUser1;
    private static User mockUser2;
    private static User mockUser3;
    private static User mockUserCreation;
    private static User mockUserModification;
    private static User mockUserDeletion;
    private static List<User> dummyDb;

    ObjectMapper om = new ObjectMapper();

    @Autowired
    UserController userController;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserServiceImpl userService;

    @BeforeAll
    static void setUpBeforeClass() {
        mockUser1 = new User(1, "L3viathan", "L3viathan@gmail.com", "password", "Levi", "Choi", LocalDate.now());
        mockUser2 = new User(2, "FullSol", "FullSol@gmail.com", "password", "Calvin", "Raines", LocalDate.now());
        mockUser3 = new User(3, "jularmerme", "jularmerme@gmail.com", "password", "Julian", "Mercado", LocalDate.now());

        mockUserCreation = new User(4, "pyaeger", "pyaeger@gmail.com", "password", "Patrick", "Yaeger",
                LocalDate.now());

        mockUserModification = new User(5, "briiitelord", "briiitelord@gmail.com", "password", "Joachim", "Ogodi",
                LocalDate.now());

        mockUserDeletion = new User(1, "JohnnyBaddie", "JohnnyBaddie@gmail.com", "password", "Johnny", "Baddie",
                LocalDate.now());

        dummyDb = new ArrayList<>();
        dummyDb.add(mockUser1);
        dummyDb.add(mockUser2);
        dummyDb.add(mockUser3);
        dummyDb.add(mockUserCreation);
        dummyDb.add(mockUserModification);
        dummyDb.add(mockUserDeletion);
    }

    @Test
    @Order(1)
    @DisplayName("1. Create User")
    void testCreateUser() throws Exception {
        when(userService.createUser(mockUserCreation)).thenReturn(true);
        RequestBuilder request = MockMvcRequestBuilders.post("/api/v1/users/1")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(om.writeValueAsString(mockUserCreation))
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(om.writeValueAsString(ClientMessageUtil.CREATION_SUCCESSFUL),
                result.getResponse().getContentAsString());
    }
}
