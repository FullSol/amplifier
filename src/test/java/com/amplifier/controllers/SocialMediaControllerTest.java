package com.amplifier.controllers;

import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.UserSocialMedia;
import com.amplifier.services.UserSocialMediaService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;



@RunWith(SpringRunner.class)
@WebMvcTest(UserSocialMediaController.class)
public class SocialMediaControllerTest {

  private UserSocialMedia sm1, sm2, sm3;
  List<UserSocialMedia> dummyDB;

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserSocialMediaService socialService;

  @BeforeAll
  public void setUp() {
    sm1 = new UserSocialMedia("https://twitter.com/myprofile", "https://facebook.com/myprofile", "https://instagram.com/myprofile");

    dummyDB = new ArrayList<UserSocialMedia>();
    dummyDB.add(sm1);
  }


}
