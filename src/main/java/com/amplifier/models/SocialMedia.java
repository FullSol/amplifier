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
@Table(name = "user_social_media")
@ApiModel(value = "user_social_media", description = "All the user social media can be found here")
public @Data class SocialMedia {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @ApiModelProperty(name = "socialMediaId", notes="")
  private int socialMediaId;

  @Column(name="twitterLink")
  @ApiModelProperty(name = "twitterLink", notes ="")
  private String twitterLink;

  @Column(name="facebookLink")
  @ApiModelProperty(name = "facebookLink", notes ="")
  private String facebookLink;

  @Column(name="instagramLink")
  @ApiModelProperty(name = "instagramLink", notes ="")
  private String instagramLink;

  public SocialMedia() {
  }

  public SocialMedia(String twitterLink, String facebookLink, String instagramLink) {
    this.twitterLink = twitterLink;
    this.facebookLink = facebookLink;
    this.instagramLink = instagramLink;
  }

  public SocialMedia(int socialMediaId, String twitterLink, String facebookLink, String instagramLink) {
    this.socialMediaId = socialMediaId;
    this.twitterLink = twitterLink;
    this.facebookLink = facebookLink;
    this.instagramLink = instagramLink;
  }
  
}
