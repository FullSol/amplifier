package com.amplifier.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "user_blizzard_accounts")
@Data
@ApiModel(value = "User_Blizzard_Accounts", description = "This model serves as the basic model for all user blizzard account entity API operations.")
public class UserBlizzardAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(name = "id", value = "An integer value that serves as the unique identifier for any user bliizard account entity.", required = true)
    private int id;

    @Column(name = "battle_tag")
    @ApiModelProperty(name = "battle_tag", value = "A String value that serves as player-chosen nickname associated with a blizzard account entity.", required = true)
    private String battleTag;

    @OneToMany(fetch = FetchType.LAZY)
    private List<UserCharacter> characters;

    @ManyToOne
    private User user;

    public UserBlizzardAccount() {
        super();
    }

    /**
     * @param accountName
     */
    public UserBlizzardAccount(String battleTag) {
        this.battleTag = battleTag;
    }

    /**
     * @param battleTag
     * @param characters
     * @param user
     */
    public UserBlizzardAccount(String battleTag, List<UserCharacter> characters, User user) {
        this.battleTag = battleTag;
        this.characters = characters;
        this.user = user;
    }

    /**
     *
     * @param id
     * @param battleTag
     * @param characters
     * @param user
     */
    public UserBlizzardAccount(int id, String battleTag, List<UserCharacter> characters, User user) {
        this.id = id;
        this.battleTag = battleTag;
        this.characters = characters;
        this.user = user;
    }
}
