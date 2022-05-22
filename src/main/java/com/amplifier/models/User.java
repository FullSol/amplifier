package com.amplifier.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Character character;
    private UserSocialMedia socialMedia;
    private LocalDate joinDate;
    private UserRole role;
    private boolean active;

    public User() {
    }

    public User(int id, String username, String email, String password, String firstName, String lastName,
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

}
