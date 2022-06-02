package com.amplifier.controllers;

import com.amplifier.models.UserCharacter;
import com.amplifier.services.UserCharacterService;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(UserCharacterController.class)
public class UserCharacterControllerIntTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserCharacterService characterService;

  UserCharacter wizard = new UserCharacter(1, "wiz", "wizard", "female", 101, 2000, 260, false, true, false);
  UserCharacter barbarian = new UserCharacter(2, "barb", "barbarian", "male", 102, 5000, 300, true, true, false);
  UserCharacter necromancer = new UserCharacter(3, "necro", "necromancer", "male", 1, 0, 350, true, true, true);

}