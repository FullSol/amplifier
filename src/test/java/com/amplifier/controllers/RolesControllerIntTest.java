package com.amplifier.controllers;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.UserRole;
import com.amplifier.services.UserRolesService;
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

/**
 * @author Levi Choi
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(UserRolesController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RolesControllerIntTest {
    private static UserRole mockRole1;
    private static UserRole mockRole2;
    private static UserRole mockRoleCreation;
    private static UserRole mockRoleUpdation;
    private static UserRole mockRoleDeletion;
    private static List<UserRole> mockDb;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
                        MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
    
    ObjectMapper om = new ObjectMapper();

    @Autowired
        UserRolesController userRolesController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserRolesService userRolesService;

    @BeforeAll
         static void setUpBeforeClass() throws Exception {
            mockRole1 = new UserRole(1, "User");
            mockRole2 = new UserRole(2, "Admin");

            mockRoleCreation = new UserRole(3, "Moderator");

           // mockRoleUpdation = mockRoleCreation;
            //mockRoleUpdation.setRoleName("Johnny");
            //mockRoleModification.setEmail("Johnny@gmail.com");
            // mockRoleDeletion = new UserRole();
            mockDb = new ArrayList<>();
            mockDb.add(mockRole1);
            mockDb.add(mockRole2);
    }
    @Test
        @Order(1)
        @DisplayName("1. AppContext")
        public void contextLoads() {
                assertThat(userRolesController).isNotNull();
        }
    @Test
    @Order(2)
        @DisplayName("2. Get all user roles.")
        public void getUserRoless_ShouldReturnUserRoless() throws Exception {
                //
                when(userRolesService.getAllUserRoles()).thenReturn(mockDb);

                //
                RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/users");
                MvcResult result = mockMvc.perform(request).andReturn();

                //
                assertEquals(om.writeValueAsString(mockDb), result.getResponse().getContentAsString());
        }


}
