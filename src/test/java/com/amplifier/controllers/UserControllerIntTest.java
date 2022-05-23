package com.amplifier.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.User;
import com.amplifier.services.UserService;
import com.amplifier.util.ClientMessageUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author Calvin Raines
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerIntTest {

        private static User mockUser1;
        private static User mockUser2;
        private static User mockUserCreation;
        private static User mockUserModification;
        private static User mockUserDeletion;
        private static List<User> dummyDb;

        // User this is you do not have a LocalDate
        // ObjectMapper om = new ObjectMapper();

        // Use this if you get an error about package not being default in jax
        private static ObjectMapper om = JsonMapper.builder()
                        .addModule(new JavaTimeModule())
                        .build();

        @Autowired
        UserController userController;

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        UserService userService;

        @BeforeAll
        static void setUpBeforeClass() throws Exception {
                System.out.println("setUpBeforeClass() :: building test objects...");
                mockUser1 = new User();
                mockUser2 = new User();

                mockUserCreation = new User();

                mockUserModification = mockUserCreation;
                mockUserModification.setFirstName("Jolly Munchers");
                mockUserModification.setEmail("");

                mockUserDeletion = new User();

                dummyDb = new ArrayList<>();
                dummyDb.add(mockUser1);
                dummyDb.add(mockUser2);
        }

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

        @Test
        @Order(4)
        @DisplayName("4. Attempt to pull vaid user")
        public void getUser_ShouldReturnUser() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders.get("/user/cf126b83-8663-46c0-8dcd-5915257ebf63"))
                                .andExpect(status().isOk())
                                .andExpect((ResultMatcher) jsonPath("id"))
                                .andExpect((ResultMatcher) jsonPath("username"))
                                .andExpect((ResultMatcher) jsonPath("password"))
                                .andExpect((ResultMatcher) jsonPath("email"))
                                .andExpect((ResultMatcher) jsonPath("firstName"))
                                .andExpect((ResultMatcher) jsonPath("lastName"));
        }

        public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
                        MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

        @Test
        @Order(5)
        @DisplayName("5. Create a new user")
        public void postUser_ShouldReturnSuccess() throws Exception {

                when(userService.createUser(mockUserCreation)).thenReturn(true);

                RequestBuilder request = MockMvcRequestBuilders.post("/api/v1/user")
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .content(om.writeValueAsString(mockUserCreation))
                                .contentType(MediaType.APPLICATION_JSON);

                MvcResult result = mockMvc.perform(request).andReturn();
                assertEquals(om.writeValueAsString(ClientMessageUtil.CREATION_SUCCESSFUL),
                                result.getResponse().getContentAsString());
        }

        @Test
        @Order(6)
        @DisplayName("6. Create a new user - failed")
        public void postUser_ShouldReturnFailed() throws Exception {

                when(userService.createUser(mockUserCreation)).thenReturn(true);

                RequestBuilder request = MockMvcRequestBuilders.post("/api/v1/user")
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .content(om.writeValueAsString(mockUserCreation))
                                .contentType(MediaType.APPLICATION_JSON);

                MvcResult result = mockMvc.perform(request).andReturn();
                assertEquals(om.writeValueAsString(ClientMessageUtil.CREATION_FAILED),
                                result.getResponse().getContentAsString());
        }

}
