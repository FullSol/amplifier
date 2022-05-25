package com.amplifier.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.List;
import com.amplifier.services.UserRolesService;
import com.amplifier.models.UserRole;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserRolesService.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserRolesServiceTest {
	
	@Autowired
	UserRolesServiceImpl userRolesService;

	@Autowired
	MockMvc mockMvc;

	@MockBean
	UserRolesService userRolesService;

	@Test
	@Order(1)
	@DisplayName("1. AppContext")
	public void contextLoads() {
		assertThat(userRolesService).isNotNull();
	}

	
	@Test
	@Order(2)
	@DisplayName("2. Test to find invalid user role by id")
	public void findUserRolesServiceById_ShouldReturn404() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/img_post/1"))
				.andExpect(status().is4xxClientError());
	}	
	
	
	@Test
	@Order(3)
	@DisplayName("3. Find All Img Posts")
	public void findAllImgPosts_ShouldReturnImgPosts() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/img_posts")).andExpect(status().isOk())
				.andExpect((ResultMatcher) jsonPath("id")).andExpect((ResultMatcher) jsonPath("img_location"))
				.andExpect((ResultMatcher) jsonPath("author_id"));
	}	
	
	

	
	
	@Test
	@Order(4)
	@DisplayName("4. Delete Img Post")
	public void deleteImgPost() throws Exception {
		Mockito.when(ImgPostService.deleteImgPost(1)).thenReturn(true);
		mockMvc.perform(MockMvcRequestBuilders.delete("/imgposts", 1))
				.andExpect(status().isOk());
	}
	
	
	
	
	
    public List<UserRole> getAllUserRoles();
    
    
    
}
