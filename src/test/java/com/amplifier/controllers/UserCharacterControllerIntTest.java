package com.amplifier.controllers;

import java.util.ArrayList;

import com.amplifier.repositories.CharacterRepository;
import com.amplifier.services.CharacterService;
import com.amplifier.models.UserCharacters;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CharacterController.class)
public class UserCharacterControllerIntTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CharacterService characterService;

  UserCharacters wizard = new UserCharacters(1, "wiz", "wizRealm");
  UserCharacters barbarian = new UserCharacters(2, "barb", "barbRealm");
  UserCharacters necromancer = new UserCharacters(3, "necro", "necroRealm");
  UserCharacters crusader = new UserCharacters(4, "crusName", "crusRealm");
  UserCharacters monk = new UserCharacters(5, "monkName", "monkRealm");


  @Test
  @Order(1)
  @DisplayName("1. Add New Character")
  public void addNewCharacter() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
    .post("/character")
    .content(asJsonString(new UserCharacters(6, "Witch Doctor", "doctorRealm")))
    .contentType(MediaType.APPLICATION_JSON)
    .accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isCreated())
    .andExpect(MockMvcResultMatchers.jsonPath("$.characterId").exists());
  }

  @Test
  @Order(2)
  @DisplayName("2. Update Character")
  public void updateCharacter() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
    .put("/character/{id}", 3)
    .content(asJsonString(necromancer))
    .contentType(MediaType.APPLICATION_JSON)
    .accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk())
    .andExpect(MockMvcResultMatchers.jsonPath("#.characterName").value("necroName"))
    .andExpect(MockMvcResultMatchers.jsonPath("$.characterRealm").value("necroRealm"));
  }

  @Test
  @Order(3)
  @DisplayName("3. Delete Character")
  public void deleteCharacter() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
    .delete("/character/{id}", 1))
    .andExpect(status().isAccepted());
  }

  @Test
  @Order(4)
  @DisplayName("4. Get Character by Id")
  public void getCharacterById() {
     mockMvc.perform(MockMvcRequestBuilders
      .get("/character/{id}", 1)
      .accept(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.characterId").value(1));
  }

  @Test
  @Order(5)
  @DisplayName("5. Get All Characters")
  public void getAllCharacters() {
    mockMvc.perform(MockMvcRequestBuilders
      .get("/characters")
      .accept(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.characters").exists())
      .adnExpect(MockMvcResultMatchers.jsonPath("$.characters[*].characterId").isNotEmpty());
  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}