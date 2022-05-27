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
@Table(name = "users")
@Data
@ApiModel(value = "Users", description = "This model serves as the basic model for all user entity API operations.")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(name = "id", notes = "An integer value that serves as the unique identifier for any user entity.", required = true, value = "1")
    private int id;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id", unique = true)
    private Character character;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "social_id", unique = true)
    private UserSocialMedia socialMedia;

    @Column(name = "join_date", nullable = false)
    @ApiModelProperty(name = "join_date", notes = "A date value that serves as the joined date for the user.", required = true)
    private LocalDate joinDate;

    // Should this be another @OneToOne column join? -- userRole role ID -> Id in
    // userRole model class
    @Column(name = "role_id", unique = true, nullable = false)
    @ApiModelProperty(name = "role_id", notes = "A integer value that serves as the role id for the user.", required = true)
    private UserRole role;

    @Column(name = "active", unique = true, nullable = false)
    @ApiModelProperty(name = "active", notes = "A boolean value that serves as the user's active status indication.", required = true)
    private boolean active;

    public User() {
    }

    public User(String username, String email, String password, String firstName, String lastName,
            LocalDate joinDate) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.joinDate = joinDate;
    }

    public User(String username, String email, String password, String firstName, String lastName, Character character,
            UserSocialMedia socialMedia,
            LocalDate joinDate, UserRole role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.character = character;
        this.socialMedia = socialMedia;
        this.joinDate = joinDate;
        this.role = role;
    }

    public User(String username, String email, String password, String firstName, String lastName, Character character,
            UserSocialMedia socialMedia,
            LocalDate joinDate, UserRole role, boolean active) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.character = character;
        this.socialMedia = socialMedia;
        this.joinDate = joinDate;
        this.role = role;
        this.active = active;
    }

    public User(int id, String username, String email, String password, String firstName, String lastName,
            Character character,
            UserSocialMedia socialMedia, LocalDate joinDate, UserRole role, boolean active) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.character = character;
        this.socialMedia = socialMedia;
        this.joinDate = joinDate;
        this.role = role;
        this.active = active;
    }

    public User(int i, String string, String string2, String string3, String string4, String string5, String string6,
            int j) {
    }

    public User(int id, String firstName, String lastName, String email, String password, int roleCode) {
    }

}
