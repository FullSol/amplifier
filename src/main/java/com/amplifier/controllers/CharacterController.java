package com.amplifier.controllers;

import java.util.List;

import com.amplifier.models.ClientMessage;
import com.amplifier.models.User;
import com.amplifier.services.CharacterService;
import com.amplifier.services.UserService;

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
    private CharacterService userService;

}
