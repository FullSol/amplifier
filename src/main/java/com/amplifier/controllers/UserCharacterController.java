package com.amplifier.controllers;

import com.amplifier.services.CharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1")
@Api(value = "CharacterRestController", description = "REST controller related to Character Entities")
public class CharacterController {

    @Autowired
    private CharacterService userService;

}
