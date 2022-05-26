package com.amplifier.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users_social_media")
public class UserSocialMedia {

    private int id;
    private String twitterLink;
    private String facebookLink;
    private String instagramLink;

}
