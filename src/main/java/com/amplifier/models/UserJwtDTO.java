package com.amplifier.models;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

@Data
public class UserJwtDTO {
    private UUID id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private UserBlizzardAccount blizzardAccountId;
    private UserSocialMedia socialMediaId;
    private LocalDate joinDate;
    private UserRole role;
    private boolean active;

    /**
     * 
     */
    public UserJwtDTO() {
    }

    /**
     * @param username
     * @param email
     * @param firstName
     * @param lastName
     * @param blizzardAccountId
     * @param socialMediaId
     * @param joinDate
     * @param role
     */
    public UserJwtDTO(String username, String email, String firstName, String lastName,
            UserBlizzardAccount blizzardAccountId, UserSocialMedia socialMediaId, LocalDate joinDate, UserRole role,
            boolean active) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.blizzardAccountId = blizzardAccountId;
        this.socialMediaId = socialMediaId;
        this.joinDate = joinDate;
        this.role = role;
        this.active = active;
    }

    /**
     * @param id
     * @param username
     * @param email
     * @param firstName
     * @param lastName
     * @param blizzardAccountId
     * @param socialMediaId
     * @param joinDate
     * @param role
     */
    public UserJwtDTO(UUID id, String email, String username, String firstName, String lastName,
            UserBlizzardAccount blizzardAccountId, UserSocialMedia socialMediaId, LocalDate joinDate, UserRole role,
            boolean active) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.blizzardAccountId = blizzardAccountId;
        this.socialMediaId = socialMediaId;
        this.joinDate = joinDate;
        this.role = role;
        this.active = active;
    }

}
