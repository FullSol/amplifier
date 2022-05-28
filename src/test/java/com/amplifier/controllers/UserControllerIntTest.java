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
import com.amplifier.models.UserBlizzardAccount;
import com.amplifier.models.UserRole;
import com.amplifier.models.UserSocialMedia;
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
        private static UserSocialMedia mockSocialMedia1;
        private static UserSocialMedia mockSocialMedia2;
        private static UserSocialMedia mockSocialMedia3;
        private static UserBlizzardAccount mockAccount1;
        private static UserBlizzardAccount mockAccount2;
        private static UserBlizzardAccount mockAccount3;
        private static UserRole mockRole1;
        private static UserRole mockRole2;
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

                mockAccount1 = new UserBlizzardAccount("Solsphere#1100");
                mockAccount2 = new UserBlizzardAccount("Patrickometry#1100");
                mockAccount3 = new UserBlizzardAccount("JMercado#1100");
                mockSocialMedia1 = new UserSocialMedia("www.solsphere.twitter.com", "www.solsphere.facebook.com", "www.solsphere.instagram.com");
                mockSocialMedia2 = new UserSocialMedia("www.patrickometry.twitter.com", "www.patrickometry.facebook.com", "www.patrickometry.instagram.com");
                mockSocialMedia3 = new UserSocialMedia("www.julian.twitter.com", "www.juian.facebook.com", "www.julian.instagram.com");
                mockRole1 = new UserRole("User");
                mockRole2 =  new UserRole("Admin");

                mockUser1 = new User("8e4ac3a8-ae4a-4ea1-85a8-9d9d1bff8f60", "FullSol", "fullsol@gmail.com", "password", "Calvin", "Raines", mockAccount1, mockSocialMedia1,
                                LocalDate.now(), mockRole1, true);
                mockUser2 = new User("Patrickometry", "patrick@gmail.com", "password", "Patrick", "Yaegar", mockAccount2, mockSocialMedia2,
                LocalDate.now(), mockRole2, true);

                mockUserCreation = new User("JulianMercado", "julianmercado@gmail.com", "password", "Julian", "Mercado", mockAccount3, mockSocialMedia3,
                LocalDate.now(), mockRole2, true);

                mockUserModification = mockUserCreation;
                mockUserModification.setFirstName("Johnny");
                mockUserModification.setEmail("Johnny@gmail.com");

                //mockUserDeletion = new User();

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
                when(userService.getAll()).thenReturn(dummyDb);

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
                when(userService.getById("8e4ac3a8-ae4a-4ea1-85a8-9d9d1bff8f60")).thenReturn(mockUser1);

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
                when(userService.getById("8e4ac3a8-ae4a-4ea1-85a8-9d9d1bff8f60")).thenReturn(mockUser1);

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
                when(userService.add(mockUserCreation)).thenReturn(true);

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
                when(userService.add(mockUserCreation)).thenReturn(true);

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
                when(userService.edit(mockUserModification)).thenReturn(true);

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
                when(userService.edit(mockUserModification)).thenReturn(true);

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
                when(userService.remove(mockUser1.getId())).thenReturn(true);

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
                when(userService.remove(mockUser1.getId())).thenReturn(true);

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
