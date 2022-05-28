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
public class UserCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @ApiModelProperty(name = "id", notes = "An integer value that serves as the unique identifier for any user entity.", required = true, value = "1")
    private int id;

    @Column(name = "name")
    @ApiModelProperty(name = "name", notes = "")
    private String name;

    @Column(name = "realm")
    @ApiModelProperty(name = "realm", notes = "")
    private String realm;

    public UserCharacter() {
        super();
    }

    /**
     * @param name
     * @param realm
     */
    public UserCharacter(String name, String realm) {
        this.name = name;
        this.realm = realm;
    }

    /**
     * @param id
     * @param name
     * @param realm
     */
    public UserCharacter(int id, String name, String realm) {
        this.id = id;
        this.name = name;
        this.realm = realm;
    }

}