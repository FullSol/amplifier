package com.amplifier.controllers;

import static com.amplifier.util.ClientMessageUtil.CREATION_FAILED;
import static com.amplifier.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.DELETION_FAILED;
import static com.amplifier.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.amplifier.util.ClientMessageUtil.UPDATE_FAILED;
import static com.amplifier.util.ClientMessageUtil.UPDATE_SUCCESSFUL;

import java.util.List;

import com.amplifier.models.ClientMessage;
import com.amplifier.models.UserCharacter;
import com.amplifier.services.UserCharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class UserCharacterController {

    @Autowired
    private UserCharacterService service;

    @GetMapping("/characters")
    @ApiOperation(value = "Find all characters", notes = "Provides a list of all characters from the API", response = UserCharacter.class)
    public @ResponseBody List<UserCharacter> getAllCharacters() {
        return service.getAll();
    }

    @ApiOperation(value = "Find character by id number", notes = "Provide an id to lookup a specific character from the API", response = UserCharacter.class)
    @GetMapping(path = "/character?id={id}")
    public @ResponseBody UserCharacter getCharacterById(@RequestParam(value = "id", name = "id") int id) {
        return service.getById(id);
    }

    @PostMapping("/character")
    @ApiOperation(value = "Create a new character entity.", notes = "Add a new character in the API")
    public @ResponseBody ClientMessage createCharacter(@RequestBody UserCharacter character) {
        return service.add(character) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PatchMapping("/character?id={id}")
    @ApiOperation(value = "Update a character by ID", notes = "Provide an Id to update a specific character in the the API")
    public @ResponseBody ClientMessage updateCharacter(@RequestBody UserCharacter character) {
        return service.edit(character) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @DeleteMapping("/character?id={id}")
    @ApiOperation(value = "Delete a character by ID", notes = "Provide an Id to deletes a specific character from the API.")
    public @ResponseBody ClientMessage deleteCharacter(@RequestBody int id) {
        return service.remove(id) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }

}
