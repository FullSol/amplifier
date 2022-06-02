package com.amplifier.models;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
@ApiModel(value = "Users", description = "This model serves as the basic model for all user entity API operations.")
public class User {

    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    @ApiModelProperty(name = "id", value = "A UUID value that serves as the unique identifier for any user entity.", required = true)
    private UUID id;

    @Column(name = "username", unique = true, nullable = false)
    @ApiModelProperty(name = "username", value = "A String value that serves as the username for the user.", required = true)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    @ApiModelProperty(name = "email", value = "A String value that serves as the email for the user.", required = true)
    private String email;

    @Column(name = "password", nullable = false)
    @ApiModelProperty(name = "password", value = "A String value that serves as the password for the user.", required = true)
    private String password;

    @Column(name = "first_name", nullable = false)
    @ApiModelProperty(name = "first_name", value = "A String value that serves as the first_name for the user.", required = true)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @ApiModelProperty(name = "last_name", value = "A String value that serves as the last_name for the user.", required = true)
    private String lastName;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "social_id", unique = true)
    @ApiModelProperty(name = "social_media_id", value = "An integer value that represents the social media information of the user.", required = true)
    private UserSocialMedia socialMedia;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
    private List<ImgPost> imgPosts;

    @Column(name = "join_date", nullable = false)
    @ApiModelProperty(name = "join_date", value = "A date value that serves as the joined date for the user.", required = true)
    private LocalDate joinDate;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    @ApiModelProperty(name = "user_role_id", value = "A integer value that serves as the role id for the user.", required = true)
    private UserRole userRole;

    @Column(name = "active", nullable = false)
    @ApiModelProperty(name = "active", value = "A boolean value that serves as the user's active status indication.", required = true)
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
     * @param userRole
     * @param active
     */
    public User(String username, String email, String password, String firstName, String lastName,
            UserBlizzardAccount blizzardAccount, UserSocialMedia socialMedia, LocalDate joinDate, UserRole userRole,
            boolean active) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        // this.blizzardAccount = blizzardAccount;
        this.socialMedia = socialMedia;
        this.joinDate = joinDate;
        this.userRole = userRole;
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
     * @param userRole
     * @param active
     */
    public User(UUID id, String username, String email, String password, String firstName, String lastName,
            UserBlizzardAccount blizzardAccount, UserSocialMedia socialMedia, LocalDate joinDate, UserRole userRole,
            boolean active) {
        super();
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        // this.blizzardAccount = blizzardAccount;
        this.socialMedia = socialMedia;
        this.joinDate = joinDate;
        this.userRole = userRole;
        this.active = active;
    }

}
