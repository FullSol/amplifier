package com.amplifier.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "user_character")
@Data
@ApiModel(value = "Character", description = "This model serves as the basic model for all user character entity API operations.")
public class UserCharacter {

    @Id
    @Column(name = "id")
    @ApiModelProperty(name = "id", value = "An integer value that serves as the unique identifier for any chracter entity.", required = true)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_blizzard_account_id")
    @ApiModelProperty(name = "blizzard_account_id", value = "An integer value that serves as the blizzard account id for a character", required = true)
    private UserBlizzardAccount userBlizzardAccount;

    @Column(name = "name")
    @ApiModelProperty(name = "name", value = "A String value that serves as the name for the character", required = true)
    private String name;

    @Column(name = "class")
    @ApiModelProperty(name = "class", value = "A string value that serves as the class of the character", required = true)
    private String _class;

    @Column(name = "gender")
    @ApiModelProperty(name = "gender", value = "A String value that denotes the gender of the character", required = true)
    private String gender;

    @Column(name = "level")
    @ApiModelProperty(name = "level", value = "An integer value that indicates the level of the character", required = true)
    private int level;

    @Column(name = "kills_elites")
    @ApiModelProperty(name = "kills_elites", value = "An integer value that serves as the kill_elites value of the character.", required = true)
    private int killsElites;

    @Column(name = "paragon_level")
    @ApiModelProperty(name = "paragon_level", value = "An integer value indicating the paragon level of a character.", required = true)
    private int paragonLevel;

    @Column(name = "hardcore")
    @ApiModelProperty(name = "hardcore", value = "A boolean value indicating the hardcore status of a character", required = true)
    private boolean hardcore;

    @Column(name = "seasonal")
    @ApiModelProperty(name = "seasonal", value = "A boolean value indicating the seasonal status of a character", required = true)
    private boolean seasonal;

    @Column(name = "dead")
    @ApiModelProperty(name = "dead", value = "A boolean value indicating the death status of a character", required = true)
    private boolean dead;

    public UserCharacter() {
        super();
    }

    /**
     * @param name
     * @param _class
     * @param gender
     * @param level
     * @param killsElites
     * @param paragonLevel
     * @param hardcore
     * @param seasonal
     * @param dead
     */
    public UserCharacter(String name, String _class, String gender, int level, int killsElites, int paragonLevel,
            boolean hardcore, boolean seasonal, boolean dead) {
        this.name = name;
        this._class = _class;
        this.gender = gender;
        this.level = level;
        this.killsElites = killsElites;
        this.paragonLevel = paragonLevel;
        this.hardcore = hardcore;
        this.seasonal = seasonal;
        this.dead = dead;
    }

    /**
     * @param id
     * @param name
     * @param _class
     * @param gender
     * @param level
     * @param killsElites
     * @param paragonLevel
     * @param hardcore
     * @param seasonal
     * @param dead
     */
    public UserCharacter(int id, String name, String _class, String gender, int level, int killsElites,
            int paragonLevel, boolean hardcore, boolean seasonal, boolean dead) {
        this.id = id;
        this.name = name;
        this._class = _class;
        this.gender = gender;
        this.level = level;
        this.killsElites = killsElites;
        this.paragonLevel = paragonLevel;
        this.hardcore = hardcore;
        this.seasonal = seasonal;
        this.dead = dead;
    }

}