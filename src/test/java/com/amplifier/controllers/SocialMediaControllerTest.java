package com.amplifier.controllers;

import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.UserSocialMedia;
import com.amplifier.services.SocialMediaService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@RunWith(SpringRunner.class)
@WebMvcTest(SocialMediaController.class)
public class SocialMediaControllerTest {

  private UserSocialMedia sm1, sm2, sm3;
  List<UserSocialMedia> dummyDB;

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private SocialMediaService socialService;

  @BeforeAll
  public void setUp() {
    sm1 = new UserSocialMedia("https://twitter.com/myprofile", "https://facebook.com/myprofile", "https://instagram.com/myprofile");

    dummyDB = new ArrayList<UserSocialMedia>();
    dummyDB.add(sm1);
  }

  @Test
  @Order(1)
  @DisplayName("1. Create Social Media")
  public void createSocialMedia() throws Exception {
    mockMvc.perform( MockMvcRequestBuilders
      .post("/socialmedia")
      .content(asJsonString(new UserSocialMedia("https://twitter.com/myprofile", "https://facebook.com/myprofile", "https://instagram.com/myprofile")))
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isCreated())
      .andExpect(MockMvcResultMatchers.jsonPath("$.socialMediaId").exists());
  }

  public static String asJsonString(final Object obj) {
    try {
        return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) { 
        throw new RuntimeException(e);
    }
  }

  @Test
  @Order(2)
  @DisplayName("2. Get Social Media by Id")
  public void getSocialMediaById() throws Exception {
    mockMvc.perform( MockMvcRequestBuilders
      .get("/socialmedia/{id}", 1)
      .accept(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").value(1));
  }

  @Test
  @Order(3)
  @DisplayName("2. Update Social Media")
  public void updateSocialMedia() throws Exception {
     mockMvc.perform( MockMvcRequestBuilders
      .put("/socialmedia/{id}", 2)
      .content(asJsonString(new UserSocialMedia(2, "https://facebook.com/myprofile", "https://facebook.com/myprofile", "https://instagram.com/myprofile")))
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Facebook"))
      .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("https://facebook.com/myprofile"));
  }

  @Test
  @Order(4)
  @DisplayName("2. Get All Social Media")
  public void getAllSocialMedia() throws Exception {
    mockMvc.perform( MockMvcRequestBuilders
      .get("/socialmedia")
      .accept(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.socialmedia").exists())
      .andExpect(MockMvcResultMatchers.jsonPath("$.socialmedia[*].socialMediaId").isNotEmpty());
  }

  @Test
  @Order(5)
  @DisplayName("2. Delete Social Media")
  public void deleteSocialMedia() throws Exception {
    mockMvc.perform( MockMvcRequestBuilders.delete("/socialmedia/{id}", 1) )
        .andExpect(status().isAccepted());
  }
  
}
