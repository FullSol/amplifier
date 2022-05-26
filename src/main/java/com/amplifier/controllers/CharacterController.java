package com.amplifier.controllers;


import java.util.List;

import com.amplifier.models.Character;
import com.amplifier.services.CharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/v1")
@Api(value = "CharacterRestController", description = "REST controller related to Character Entities")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    //Get all characters

    @GetMapping("/characters")
    @ApiOperation(value = "Find all characters", notes = "Provides a list of all characters from the API", response = Character.class)
    public @ResponseBody List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    //Create character

    @PostMapping("/character")
    @ApiOperation(value = "Create a new character", notes = "Posts new characters to the API", response = Character.class)
    public @ResponseBody Character createCharacter(@RequestBody Character character) {
        return characterService.createCharacter(character) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    //RUD by ID

    @ApiOperation(value = "Find character by id number", notes = "Provide an id to lookup a specific character from the API", response = Character.class)
    @GetMapping(path = "/character?id={Id}")
    public @ResponseBody Character getCharacterById(@RequestParam(value = "id", name = "id") int id) {
        // System.out.println("TEST: " + characterService.getCharacterById(id));
        return characterService.getCharacterById(id);
    }

    @PutMapping("/character?id={Id}")
    @ApiOperation(value = "Update a character by ID", notes = "Updates a character based on Id from the API", response = Character.class)
    public @ResponseBody Character updateCharacter(@RequestBody int Id) {
        return characterService.updateCharacterById(Id) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

   

    @DeleteMapping("/character?id={Id}")
    @ApiOperation(value = "Delete a character by ID", notes = "Deletes a character based on Id from the API", response = Character.class)
    public @ResponseBody Character deleteCharacter(@RequestBody int Id) {
        return characterService.deleteCharacterById(Id) ? DELETE_SUCCESSFUL : DELETE_FAILED;
    }

   

    
    

}
