package com.amplifier.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.amplifier.services.UserService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author Calvin Raines
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerIntTest {

        @Autowired
        UserController userController;

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        UserService userService;

        @Test
        @Order(1)
        @DisplayName("1. AppContext")
        public void contextLoads() {
                assertThat(userController).isNotNull();
        }

        @Test
        @Order(2)
        @DisplayName("2. Get all users")
        public void getUsers_ShouldReturnUsers() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                                .andExpect(status().isOk())
                                .andExpect((ResultMatcher) jsonPath("id"))
                                .andExpect((ResultMatcher) jsonPath("username"))
                                .andExpect((ResultMatcher) jsonPath("password"))
                                .andExpect((ResultMatcher) jsonPath("email"))
                                .andExpect((ResultMatcher) jsonPath("firstName"))
                                .andExpect((ResultMatcher) jsonPath("lastName"));
        }

        @Test
        @Order(3)
        @DisplayName("3. Attempt to pull invalid user")
        public void getUser_ShouldReturn404() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders.get("/user/1"))
                                .andExpect(status().is4xxClientError());
        }
}
