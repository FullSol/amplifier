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

UserCharacter wizard = new UserCharacter(1, "wiz", "wizRealm");
UserCharacter barbarian = new UserCharacter(2, "barb", "barbRealm");
UserCharacter necromancer = new UserCharacter(3, "necro", "necroRealm");
UserCharacter crusader = new UserCharacter(4, "crusName", "crusRealm");
UserCharacter monk = new UserCharacter(5, "monkName", "monkRealm");

}