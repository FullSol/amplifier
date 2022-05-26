package com.amplifier.repositories;

import java.time.LocalDate;
import java.util.ArrayList;

import com.amplifier.models.Comment;

public interface CommentRepository {

    public ArrayList<Comment> findAll();

    public boolean create(Comment comment);

    public Comment findCommentById(int Id);

    public Comment findCommentByText(String comment_text); //implementation to find comment by .contains filter based on string input

    public Comment findCommentByAuthorId(int author_id);

    public Comment findCommentByImagePostId(int img_post_id);

    public Comment findCommentByCreationDate(LocalDate comment_date);

    public ArrayList<Comment> listAllCommentsByCreationDate(LocalDate comment_date);

    public boolean deleteCommentById(int id);

    public boolean updateCommentById(int id);

}
