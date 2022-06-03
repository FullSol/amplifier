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
    private String battleTag;
    private UserSocialMedia socialMediaId;
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
     * @param battleTag
     * @param socialMediaId
     * @param joinDate
     * @param role
     * @param active
     */
    public UserJwtDTO(String username, String email, String firstName, String lastName, String battleTag,
            UserSocialMedia socialMediaId, UserRole role, boolean active) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.battleTag = battleTag;
        this.socialMediaId = socialMediaId;
        this.role = role;
        this.active = active;
    }

    /**
     * @param id
     * @param username
     * @param email
     * @param firstName
     * @param lastName
     * @param battleTag
     * @param socialMediaId
     * @param joinDate
     * @param role
     * @param active
     */
    public UserJwtDTO(UUID id, String username, String email, String firstName, String lastName, String battleTag,
            UserSocialMedia socialMediaId, UserRole role, boolean active) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.battleTag = battleTag;
        this.socialMediaId = socialMediaId;
        this.role = role;
        this.active = active;
    }

}
