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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
@ApiModel(value = "Users", description = "This model serves as the basic model for all user entity API operations.")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(name = "id", notes = "An integer value that serves as the unique identifier for any user entity.", required = true, value = "1")
    private String id;

    @Column(name = "username", unique = true, nullable = false)
    @ApiModelProperty(name = "username", notes = "A String value that serves as the username for the user.", required = true)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    @ApiModelProperty(name = "email", notes = "A String value that serves as the email for the user.", required = true)
    private String email;

    @Column(name = "password", nullable = false)
    @ApiModelProperty(name = "password", notes = "A String value that serves as the password for the user.", required = true)
    private String password;

    @Column(name = "first_name", nullable = false)
    @ApiModelProperty(name = "first_name", notes = "A String value that serves as the first_name for the user.", required = true)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @ApiModelProperty(name = "last_name", notes = "A String value that serves as the last_name for the user.", required = true)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "blizzard_account_id", unique = true)
    private UserBlizzardAccount blizzardAccount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "social_id", unique = true)
    private UserSocialMedia socialMedia;

    @Column(name = "join_date", nullable = false)
    @ApiModelProperty(name = "join_date", notes = "A date value that serves as the joined date for the user.", required = true)
    private LocalDate joinDate;

    @ManyToOne
    @JoinColumn(name = "role_id", unique = true, nullable = false)
    @ApiModelProperty(name = "role_id", notes = "A integer value that serves as the role id for the user.", required = true)
    private UserRole role;

    @Column(name = "active", unique = true, nullable = false)
    @ApiModelProperty(name = "active", notes = "A boolean value that serves as the user's active status indication.", required = true)
    private boolean active;

    public User() {
        super();
    }

    /**
     * @param username
     * @param email
     * @param password
     * @param firstName
     * @param lastName
     * @param blizzardAccount
     * @param socialMedia
     * @param joinDate
     * @param role
     * @param active
     */
    public User(String username, String email, String password, String firstName, String lastName,
            UserBlizzardAccount blizzardAccount, UserSocialMedia socialMedia, LocalDate joinDate, UserRole role,
            boolean active) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.blizzardAccount = blizzardAccount;
        this.socialMedia = socialMedia;
        this.joinDate = joinDate;
        this.role = role;
        this.active = active;
    }

    /**
     * @param id
     * @param username
     * @param email
     * @param password
     * @param firstName
     * @param lastName
     * @param blizzardAccount
     * @param socialMedia
     * @param joinDate
     * @param role
     * @param active
     */
    public User(String id, String username, String email, String password, String firstName, String lastName,
            UserBlizzardAccount blizzardAccount, UserSocialMedia socialMedia, LocalDate joinDate, UserRole role,
            boolean active) {
        super();
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.blizzardAccount = blizzardAccount;
        this.socialMedia = socialMedia;
        this.joinDate = joinDate;
        this.role = role;
        this.active = active;
    }

}
