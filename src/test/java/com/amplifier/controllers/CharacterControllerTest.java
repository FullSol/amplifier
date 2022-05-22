package com.amplifier.controllers;

import java.util.ArrayList;

import com.amplifier.services.CharacterService;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

public class CharacterControllerTest {

  @Autowired
  CharacterController charController;

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  CharacterService charService;

  @Test
  @Order(1)
  @DisplayName("1. Add New Character")
  public boolean addNewCharacter() {
    return true;
  }

  @Test
  @Order(2)
  @DisplayName("2. Update Character")
  public void updateCharacter() {

  }

  @Test
  @Order(3)
  @DisplayName("3. Delete Character")
  public void deleteCharacter() {

  }

  @Test
  @Order(4)
  @DisplayName("4. Get Character by Id")
  public Character getCharacterById() {
    return null;
  }

  @Test
  @Order(5)
  @DisplayName("5. Get All Characters")
  public ArrayList<Character> getAllCharacters() {
    return null;
  }

}
