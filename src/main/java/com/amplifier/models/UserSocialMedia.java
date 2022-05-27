package com.amplifier.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users_social_media")
@ApiModel(value = "users_social_media", description = "All the user social media can be found here")
@Data
public class UserSocialMedia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @ApiModelProperty(name = "socialMediaId", notes = "")
  private int id;

  @Column(name = "twitterLink")
  @ApiModelProperty(name = "twitterLink", notes = "")
  private String twitterLink;

  @Column(name = "facebookLink")
  @ApiModelProperty(name = "facebookLink", notes = "")
  private String facebookLink;

  @Column(name = "instagramLink")
  @ApiModelProperty(name = "instagramLink", notes = "")
  private String instagramLink;

  public UserSocialMedia() {
  }

  public UserSocialMedia(String twitterLink, String facebookLink, String instagramLink) {
    this.twitterLink = twitterLink;
    this.facebookLink = facebookLink;
    this.instagramLink = instagramLink;
  }

  public UserSocialMedia(int id, String twitterLink, String facebookLink, String instagramLink) {
    this.id = id;
    this.twitterLink = twitterLink;
    this.facebookLink = facebookLink;
    this.instagramLink = instagramLink;
  }

}
