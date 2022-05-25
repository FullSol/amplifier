package com.amplifier.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.UserRole;
import com.amplifier.repositories.UserRolesRepository;
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
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
// @ContextConfiguration(classes=ApplicationContext.class)
@WebMvcTest(UserRolesService.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserRolesServiceTest {

	private static UserRole mockUserRole1;
	private static List<UserRole> mockDb;

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	// User this is you do not have a LocalDate
	// ObjectMapper om = new ObjectMapper();

	// Use this if you get an error about package not being default in jax
	private static ObjectMapper om = JsonMapper.builder().addModule(new JavaTimeModule()).build();	
	
	
	@Autowired
	MockMvc mockMvc;

	@MockBean
	private UserRolesRepository userRolesRepository;
	
	@MockBean
	private UserRolesService userRolesService;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		mockUserRole1 = new UserRole(1, "");
		mockDb = new ArrayList<>();
		mockDb.add(mockUserRole1);

	}

	@Test
	@Order(1)
	@DisplayName("1. AppContext")
	public void contextLoads() {
		assertThat(userRolesService).isNotNull();
	}

	
	@Test
	@Order(2)
	@DisplayName("2. Test to find invalid user role")
	public void findUserRoleById_ShouldReturn404() throws Exception {
		Integer id = null;
		String role = "nonmember";
		Mockito.when(userRolesRepository.getUserRoleByRole(role)).thenReturn(null);
		boolean result = userRolesService.isValidUserRoleViolated(id, role);
		assertFalse(result);

	}	
	
	
	@Test
	@Order(3)
	@DisplayName("3. Find All User Roles")
	public void findAllUserRoles_ShouldReturnUserRoles() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user_roles")).andExpect(status().isOk())
				.andExpect((ResultMatcher) jsonPath("id")).andExpect((ResultMatcher) jsonPath("role"));
	}	
	
	
	@Test
	@Order(4)
	@DisplayName("4. Delete User Role")
	public void deleteUserRole() throws Exception {
		Mockito.when(UserRolesService.deleteUserRole(1)).thenReturn(true);
		mockMvc.perform(MockMvcRequestBuilders.delete("/user_roles", 1))
				.andExpect(status().isOk());
	}
	
    
}
