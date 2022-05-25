package com.amplifier.controllers;

import com.amplifier.services.CharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/character")
public class CharacterController {

  @Autowired
  private CharacterService characterService;

  public CharacterController(CharacterService characterService) {
    this.characterService = characterService;
  }

  @GetMapping("id")
  @ResponseStatus(code = HttpStatus.OK)
  public Character getCharacterById(@PathVariable int id) {
    return characterService.findCharacterById(id);
  }

}
