package com.amplifier.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
                        MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

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
                LocalDate timestamp = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
                String joinDate = formatter.format(timestamp);

                mockUser1 = new User("FullSol", "fullsol@gmail.com", "password", "Calvin", "Raines",
                                LocalDate.now());
                mockUser2 = new User("L3viathon", "L3viathon@gmail.com", "password", "Levi", "Choi", LocalDate.now());

                mockUserCreation = new User("pyaeger", "pyaeger@gmail.com", "password", "Partrick", "Yaeger",
                                LocalDate.now());

                mockUserModification = mockUserCreation;
                mockUserModification.setFirstName("Johnny");
                mockUserModification.setEmail("Johnny@gmail.com");

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
                assertThat(userService).isNotNull();
        }

        @Test
        @Order(2)
        @DisplayName("2. Get all users")
        public void getUsers_ShouldReturnUsers() throws Exception {
                //
                when(userService.getAllUsers()).thenReturn(dummyDb);

                //
                RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/users");
                MvcResult result = mockMvc.perform(request).andReturn();

                //
                assertEquals(om.writeValueAsString(dummyDb), result.getResponse().getContentAsString());
        }

        @Test
        @Order(3)
        @DisplayName("3. Attempt to pull invalid user")
        public void getUser_ShouldReturnInvalid() throws Exception {
                //
                when(userService.getUserById(1)).thenReturn(mockUser1);

                //
                RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/user?id=1");
                MvcResult result = mockMvc.perform(request).andReturn();

                //
                assertEquals(om.writeValueAsString(mockUser1), result.getResponse().getContentAsString());
        }

        @Test
        @Order(4)
        @DisplayName("4. Attempt to pull valid user")
        public void getUser_ShouldReturnUser() throws Exception {
                //
                when(userService.getUserById(1)).thenReturn(mockUser1);

                //
                RequestBuilder request = MockMvcRequestBuilders
                                .get("/api/user?id=8e4ac3a8-ae4a-4ea1-85a8-9d9d1bff8f60");
                MvcResult result = mockMvc.perform(request).andReturn();

                //
                assertEquals(om.writeValueAsString(mockUser1), result.getResponse().getContentAsString());
        }

        @Test
        @Order(5)
        @DisplayName("5. Create a new user")
        public void postUser_ShouldReturnSuccess() throws Exception {
                //
                when(userService.createUser(mockUserCreation)).thenReturn(true);

                //
                RequestBuilder request = MockMvcRequestBuilders
                                .post("/api/v1/user?id=8e4ac3a8-ae4a-4ea1-85a8-9d9d1bff8f60")
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .content(om.writeValueAsString(mockUserCreation))
                                .contentType(MediaType.APPLICATION_JSON);

                //
                MvcResult result = mockMvc.perform(request).andReturn();
                assertEquals(om.writeValueAsString(ClientMessageUtil.CREATION_SUCCESSFUL),
                                result.getResponse().getContentAsString());
        }

        @Test
        @Order(6)
        @DisplayName("6. Create a new user - failed")
        public void postUser_ShouldReturnFailed() throws Exception {
                //
                when(userService.createUser(mockUserCreation)).thenReturn(true);

                //
                RequestBuilder request = MockMvcRequestBuilders
                                .post("/api/v1/user?id=8e4ac3a8-ae4a-4ea1-85a8-9d9d1bff8f60")
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .content(om.writeValueAsString(mockUserCreation))
                                .contentType(MediaType.APPLICATION_JSON);
                MvcResult result = mockMvc.perform(request).andReturn();

                //
                assertEquals(om.writeValueAsString(ClientMessageUtil.CREATION_FAILED),
                                result.getResponse().getContentAsString());
        }

        @Test
        @Order(7)
        @DisplayName("7. Update a user")
        public void postUpdateUser_ShouldReturnTrue() throws Exception {
                //
                when(userService.updateUser(mockUserModification)).thenReturn(true);

                //
                RequestBuilder request = MockMvcRequestBuilders
                                .put("/api/v1/user?id=8e4ac3a8-ae4a-4ea1-85a8-9d9d1bff8f60")
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .content(om.writeValueAsString(mockUserModification))
                                .contentType(MediaType.APPLICATION_JSON);
                MvcResult result = mockMvc.perform(request).andReturn();

                //
                assertEquals(om.writeValueAsString(ClientMessageUtil.UPDATE_SUCCESSFUL),
                                result.getResponse().getContentAsString());
        }

        @Test
        @Order(8)
        @DisplayName("7. Update a user - failed")
        public void postUpdateUser_ShouldReturnFailed() throws Exception {
                //
                when(userService.updateUser(mockUserModification)).thenReturn(true);

                //
                RequestBuilder request = MockMvcRequestBuilders
                                .put("/api/v1/user?id=8e4ac3a8-ae4a-4ea1-85a8-9d9d1bff8f60")
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .content(om.writeValueAsString(mockUserModification))
                                .contentType(MediaType.APPLICATION_JSON);
                MvcResult result = mockMvc.perform(request).andReturn();

                //
                assertEquals(om.writeValueAsString(ClientMessageUtil.UPDATE_FAILED),
                                result.getResponse().getContentAsString());
        }

        @Test
        @Order(9)
        @DisplayName("9. Delete User")
        public void testDeleteUser() throws Exception {

                //
                when(userService.deleteUser(mockUserDeletion)).thenReturn(true);

                //
                RequestBuilder request = MockMvcRequestBuilders
                                .delete("/api/v1/user?id=8e4ac3a8-ae4a-4ea1-85a8-9d9d1bff8f60")
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .content(om.writeValueAsString(mockUserDeletion))
                                .contentType(MediaType.APPLICATION_JSON);
                MvcResult result = mockMvc.perform(request).andReturn();

                //
                assertEquals(om.writeValueAsString(ClientMessageUtil.DELETION_SUCCESSFUL),
                                result.getResponse().getContentAsString());
        }

        @Test
        @Order(10)
        @DisplayName("10. Delete User - fail")
        public void testDeleteUserFail() throws Exception {

                //
                when(userService.deleteUser(mockUserDeletion)).thenReturn(true);

                //
                RequestBuilder request = MockMvcRequestBuilders
                                .delete("/api/v1/user?id=8e4ac3a8-ae4a-4ea1-85a8-9d9d1bff8f60")
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .content(om.writeValueAsString(mockUserDeletion))
                                .contentType(MediaType.APPLICATION_JSON);
                MvcResult result = mockMvc.perform(request).andReturn();

                //
                assertEquals(om.writeValueAsString(ClientMessageUtil.DELETION_FAILED),
                                result.getResponse().getContentAsString());
        }
}
