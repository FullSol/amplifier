package com.amplifier.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user_character")
@Data
@ApiModel(value = "Character", description = "This model serves as the basic model for all user characters entity API operations.")
public class Character {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  @ApiModelProperty(name = "id", notes = "An integer value that serves as the unique identifier for any user entity.", required = true, value = "1")
  private int id;

  @Column(name = "character_name")
  @ApiModelProperty(name = "character_name", notes = "")
  private String characterName;
  
  @Column(name = "character_realm")
  @ApiModelProperty(name = "character_realm", notes = "")
  private String characterRealm;

  public Character() {
  }

  public Character(String characterName, String characterRealm) {
    this.characterName = characterName;
    this.characterRealm = characterRealm;
  }

  public Character(int id, String characterName, String characterRealm) {
    this.id = id;
    this.characterName = characterName;
    this.characterRealm = characterRealm;
  }

}
