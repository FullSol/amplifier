package com.amplifier.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "img_post_comments")
@Data
@ApiModel(value = "Comments", description = "This model serves as the basic model for all comment entity API operations.")
public class ImgPostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @ApiModelProperty(name = "id", value = "An integer value that serves as the unique identifier for any image post comment entity.", required = true)
    private int id;

    @Column(name = "comment_text", nullable = false)
    @ApiModelProperty(name = "comment_text", value = "A string value denoting the body of text making up an image post comment entity.", required = true)
    private String commentText;

    @JoinColumn(name = "img_post_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @ApiModelProperty(name = "img_post_id", value = "An integer value that serves as the unique identifier for an image post entity.", required = true)
    private ImgPost imgPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    @ApiModelProperty(name = "author", value = "User value specifiying the author of the image post comment entity.", required = true)
    private User author;

    @Column(name = "comment_date", nullable = false)
    @ApiModelProperty(name = "comment_date", value = "Date value specifiying the post date of an image post comment entity.", required = true)
    private LocalDate commentDate;

    public ImgPostComment() {
    }

    /**
     * @param commentText
     * @param imgPost
     * @param author
     * @param commentDate
     */
    public ImgPostComment(String commentText, ImgPost imgPost, User author, LocalDate commentDate) {
        this.commentText = commentText;
        this.imgPost = imgPost;
        this.author = author;
        this.commentDate = commentDate;
    }

    /**
     * @param id
     * @param commentText
     * @param imgPost
     * @param author
     * @param commentDate
     */
    public ImgPostComment(int id, String commentText, ImgPost imgPost, User author, LocalDate commentDate) {
        this.id = id;
        this.commentText = commentText;
        this.imgPost = imgPost;
        this.author = author;
        this.commentDate = commentDate;
    }

}
