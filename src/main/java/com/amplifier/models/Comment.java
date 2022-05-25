package com.amplifier.models;

import java.time.LocalDate;

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
@Table(name = "img_post_comments")
@Data
@ApiModel(value = "Comments", description = "This model serves as the basic model for all comment entity API operations.")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(name = "id", notes = "An integer value that serves as the unique identifier for any user entity.")
    private int id;

    @Column(name = "comment_text")
    @ApiModelProperty()
    private String commentText;

    @Column(name = "img_post_id")
    @ApiModelProperty()
    private int imgPostId;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @Column(name = "comment_date")
    @ApiModelProperty(name = "comment_date")
    private LocalDate commentDate;

    public Comment() {
    }

    public Comment(String commentText, int imgPostId, User author, LocalDate commentDate) {
        this.commentText = commentText;
        this.imgPostId = imgPostId;
        this.author = author;
        this.commentDate = commentDate;
    }

    public Comment(int id, String commentText, int imgPostId, User author, LocalDate commentDate) {
        this.id = id;
        this.commentText = commentText;
        this.imgPostId = imgPostId;
        this.author = author;
        this.commentDate = commentDate;
    }
}