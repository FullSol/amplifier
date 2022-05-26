package com.amplifier.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "img_posts")
@Data
@ApiModel(value = "ImgPosts", description = "This model serves as the basic model for all ImgPost entity API operations.")
public class ImgPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(name = "id", notes = "An integer value that serves as the unique identifier for any image post entity.", required = true, value = "1")
    private int id;

    @Column(name = "img_location", nullable = false)
    @ApiModelProperty(name = "imageLocation", value = "A string value describing the location of an image post entity.", required = true)
    private String imgLocation;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @ApiModelProperty(name = "author", value = "User value specifiying the author of the image post entity.", required = true)
    private User author;

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
