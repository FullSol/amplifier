package com.amplifier.models;

import io.swagger.annotations.ApiModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
@Builder
@ApiModel(value = "Users", description = "This model serves as the basic model for all ImgPost entity API operations.")
public class ImgPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "img_location")
    private String imgLocation;

    @ManyToOne
    @JoinColumn(name = "author_id")
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
