package com.amplifier.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.UserRole;
import com.amplifier.services.UserRolesService;
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

        mockRoleUpdation = mockRoleCreation;
        mockRoleUpdation.setUserRole("Creator");
        //mockRoleDeletion = new UserRole(3);
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
    @DisplayName("2. Attempt to get all user roles - success")
    public void getRoles_Success() throws Exception {

        when(userRolesService.getAll()).thenReturn(mockDb);


        RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/roles");
        MvcResult result = mockMvc.perform(request).andReturn();

        assertEquals(om.writeValueAsString(mockDb), result.getResponse().getContentAsString());
    }

    @Test
    @Order(3)
    @DisplayName("3. Attempt to get user role by id - failed.")
    public void getRoleById_Fail() throws Exception {

        when(userRolesService.getById(1)).thenReturn(mockRole1);

        RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/role?id=1");
        MvcResult result = mockMvc.perform(request).andReturn();

        assertEquals(om.writeValueAsString(mockRole1), result.getResponse().getContentAsString());
    }

    @Test
    @Order(4)
    @DisplayName("4. Attempt to get user role by id - passed.")
    public void getRoleById_Pass() throws Exception {
        when(userRolesService.getById(1)).thenReturn(mockRole1);

        RequestBuilder request = MockMvcRequestBuilders
                        .get("/api/v1/role?id=1");
        MvcResult result = mockMvc.perform(request).andReturn();

        assertEquals(om.writeValueAsString(mockRole1), result.getResponse().getContentAsString());
    }

    @Test
    @Order(5)
    @DisplayName("5. Attempt to create a new user role - failed.")
    public void postRole_Failed() throws Exception {

        when(userRolesService.add(mockRoleCreation)).thenReturn(true);

        RequestBuilder request = MockMvcRequestBuilders
                        .post("/api/v1//role?id=3")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(om.writeValueAsString(mockRoleCreation))
                        .contentType(MediaType.APPLICATION_JSON);


        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals(om.writeValueAsString(ClientMessageUtil.CREATION_SUCCESSFUL),
                        result.getResponse().getContentAsString());
    }

    @Test
    @Order(6)
    @DisplayName("6. Attempt to create a new user role- passed.")
    public void postRole_Pass() throws Exception {

            when(userRolesService.add(mockRoleCreation)).thenReturn(true);

            RequestBuilder request = MockMvcRequestBuilders
                            .post("/api/v1/role?id=3")
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                            .content(om.writeValueAsString(mockRoleCreation))
                            .contentType(MediaType.APPLICATION_JSON);

            MvcResult result = mockMvc.perform(request).andReturn();
            assertEquals(om.writeValueAsString(ClientMessageUtil.CREATION_SUCCESSFUL),
                            result.getResponse().getContentAsString());
    }

    @Test
    @Order(7)
    @DisplayName("7. Attempt to update a user role - failed")
    public void updateRole_Failed() throws Exception {

            when(userRolesService.edit(mockRoleUpdation)).thenReturn(true);

            RequestBuilder request = MockMvcRequestBuilders
                            .put("/api/v1/role?id=3")
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                            .content(om.writeValueAsString(mockRoleUpdation))
                            .contentType(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(request).andReturn();

            assertEquals(om.writeValueAsString(ClientMessageUtil.UPDATE_FAILED),
                            result.getResponse().getContentAsString());
        }

    @Test
    @Order(8)
    @DisplayName("8. Attempt to update a user role - passed")
    public void updateRole_Passed() throws Exception {

            when(userRolesService.edit(mockRoleUpdation)).thenReturn(true);

            RequestBuilder request = MockMvcRequestBuilders
                            .put("/api/v1/role?id=3")
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                            .content(om.writeValueAsString(mockRoleUpdation))
                            .contentType(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(request).andReturn();

            assertEquals(om.writeValueAsString(ClientMessageUtil.UPDATE_FAILED),
                            result.getResponse().getContentAsString());
        }

    @Test
    @Order(9)
    @DisplayName("9. Attempt to delete a user role - failed")
    public void deleteRole_Failed() throws Exception {

        when(userRolesService.remove(mockRoleDeletion.getId())).thenReturn(true);

        RequestBuilder request = MockMvcRequestBuilders
                        .delete("/api/v1/role?id=3")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(om.writeValueAsString(mockRoleDeletion))
                        .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andReturn();

        assertEquals(om.writeValueAsString(ClientMessageUtil.DELETION_FAILED),
                        result.getResponse().getContentAsString());
        }

    @Test
    @Order(10)
    @DisplayName("10. Attempt to delete a user role - passed")
    public void deleteRole_Passed() throws Exception {

        when(userRolesService.remove(mockRoleDeletion.getId())).thenReturn(true);

        RequestBuilder request = MockMvcRequestBuilders
                        .delete("/api/v1/role?id=3")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(om.writeValueAsString(mockRoleDeletion))
                        .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andReturn();

        assertEquals(om.writeValueAsString(ClientMessageUtil.DELETION_FAILED),
                        result.getResponse().getContentAsString());
        }

}
