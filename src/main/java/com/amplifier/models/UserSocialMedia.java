package com.amplifier.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "users_social_media")
@ApiModel(value = "Users_Social_Media", description = "This model serves as the basic model for all user social media entity API operations.")
@Data
public class UserSocialMedia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @ApiModelProperty(name = "socialMediaId", value = "An integer value that serves as the unique identifier for any user social media entity.", required = true)
  private int id;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  @ApiModelProperty(name = "userId", value = "An UUID value that serves as the unique identifier for any user entity.", required = true)
  private User user;

  @Column(name = "twitterLink")
  @ApiModelProperty(name = "twitterLink", value = "A String value serving as the twitter link as part of a user's social media.")
  private String twitterLink;

  @Column(name = "facebookLink")
  @ApiModelProperty(name = "facebookLink", value = "A String value serving as the facebook link as part of the user's social media.")
  private String facebookLink;

  @Column(name = "instagramLink")
  @ApiModelProperty(name = "instagramLink", value = "A String value serving as the instagram link as part of the user's social media.")
  private String instagramLink;

  public UserSocialMedia() {
  }

  /**
   * @param userId
   * @param twitterLink
   * @param facebookLink
   * @param instagramLink
   */
  public UserSocialMedia(User user, String twitterLink, String facebookLink, String instagramLink) {
    this.user = user;
    this.twitterLink = twitterLink;
    this.facebookLink = facebookLink;
    this.instagramLink = instagramLink;
  }

  /**
   * @param id
   * @param userId
   * @param twitterLink
   * @param facebookLink
   * @param instagramLink
   */
  public UserSocialMedia(int id, User user, String twitterLink, String facebookLink, String instagramLink) {
    this.id = id;
    this.user = user;
    this.twitterLink = twitterLink;
    this.facebookLink = facebookLink;
    this.instagramLink = instagramLink;
  }

}
