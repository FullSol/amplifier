package com.amplifier.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "img_posts")
@Data
@ApiModel(value = "ImgPosts", description = "This model serves as the basic model for all ImgPost entity API operations.")
public class ImgPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @ApiModelProperty(name = "id", value = "An integer value that serves as the unique identifier for any image post entity.", required = true)
    private int id;

    @Column(name = "img_caption", nullable = false)
    @ApiModelProperty(name = "caption", value = "A string value denoting the caption of an image post entity.", required = true)
    private String imgCaption;

    @Column(name = "img_location", nullable = false)
    @ApiModelProperty(name = "imageLocation", value = "A string value describing the location of an image post entity.", required = true)
    private String imgLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    @ApiModelProperty(name = "author", value = "User value specifiying the author of the image post entity.", required = true)
    private User author;

    @Column(name = "img_date", nullable = false)
    @ApiModelProperty(name = "img_date", value = "Date value specifiying the post date of an image post entity.", required = true)
    private LocalDate postDate;

    @OneToMany(fetch = FetchType.LAZY) //need to create that connection to comments
    private List<ImgPostComment> imgPostComments;

    public ImgPost() {
    }

    public ImgPost(String imgLocation, User author) {
        this.imgLocation = imgLocation;
        this.author = author;
    }

    public ImgPost(int id, String imgLocation, User author) {
        this.id = id;
        this.imgLocation = imgLocation;
        this.author = author;
    }

}
