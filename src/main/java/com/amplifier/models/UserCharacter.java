package com.amplifier.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user_character")
@Data
@ApiModel(value = "Character", description = "This model serves as the basic model for all user character entity API operations.")
public class UserCharacter {

    @Id
    @Column(name = "id")
    @ApiModelProperty(name = "id", notes = "An integer value that serves as the unique identifier for any user entity.", required = true, value = "1")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_blizzard_account_id")
    private UserBlizzardAccount userBlizzardAccount;

    @Column(name = "name")
    @ApiModelProperty(name = "name", notes = "")
    private String name;

    @Column(name = "class")
    @ApiModelProperty(name = "class", notes = "")
    private String _class;

    @Column(name = "gender")
    @ApiModelProperty(name = "gender", notes = "")
    private String gender;

    @Column(name = "level")
    @ApiModelProperty(name = "level", notes = "")
    private int level;

    @Column(name = "kills_elites")
    @ApiModelProperty(name = "kills_elites", notes = "")
    private int killsElites;

    @Column(name = "paragon_level")
    @ApiModelProperty(name = "paragon_level", notes = "")
    private int paragonLevel;

    @Column(name = "hardcore")
    @ApiModelProperty(name = "hardcore", notes = "")
    private boolean hardcore;

    @Column(name = "seasonal")
    @ApiModelProperty(name = "seasonal", notes = "")
    private boolean seasonal;

    @Column(name = "dead")
    @ApiModelProperty(name = "dead", notes = "")
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