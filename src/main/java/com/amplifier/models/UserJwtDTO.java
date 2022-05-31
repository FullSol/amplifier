package com.amplifier.models;

import java.util.UUID;

import lombok.Data;

@Data
public class UserJwtDTO {
    private UUID id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String blizzardAccountId;
    private String socialMediaId;
    private String joinDate;
    private String role;

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
    public UserJwtDTO(String username, String email, String firstName, String lastName, String blizzardAccountId,
            String socialMediaId, String joinDate, String role) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.blizzardAccountId = blizzardAccountId;
        this.socialMediaId = socialMediaId;
        this.joinDate = joinDate;
        this.role = role;
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
    public UserJwtDTO(UUID id, String username, String email, String firstName, String lastName,
            String blizzardAccountId, String socialMediaId, String joinDate, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.blizzardAccountId = blizzardAccountId;
        this.socialMediaId = socialMediaId;
        this.joinDate = joinDate;
        this.role = role;
    }

}
