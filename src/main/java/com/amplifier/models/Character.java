package com.amplifier.models;

import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user_character")
@Data
@ApiModel(value = "User_Character", description = "This model serves as the basis for all user character entity API operations")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(name = "id", notes = "An integer value that serves as the unique identifier for any user entity.", required = true, value = "1")
    private int id;

    @Column(name = "character_realm")
    @ApiModelProperty(name = "Character_Realm", notes = "A string value that serves as the user character's realm name")
    private String character_realm;

    @Column(name = "character_name")
    @ApiModelProperty(name = "Character_Name", notes = "A string value that serves as the user character's name")
    private String character_name;

    public Character() {
    }

    public Character(int id, String character_realm, String character_name) {
        this.id = id;
        this.character_realm = character_realm;
        this.character_name = character_name;
    }

    

    


}
