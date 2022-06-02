package com.amplifier.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

    @Column(name = "battle_tag", unique = true)
    @ApiModelProperty(name = "battle_tag", value = "A String value that serves as player-chosen nickname associated with a blizzard account entity.", required = true)
    private String battleTag;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    public UserBlizzardAccount() {
        super();
    }

    /**
     * @param battleTag
     * @param user
     */
    public UserBlizzardAccount(String battleTag, User user) {
        this.battleTag = battleTag;
        this.user = user;
    }

    /**
     * @param id
     * @param battleTag
     * @param user
     */
    public UserBlizzardAccount(int id, String battleTag, User user) {
        this.id = id;
        this.battleTag = battleTag;
        this.user = user;
    }

}
