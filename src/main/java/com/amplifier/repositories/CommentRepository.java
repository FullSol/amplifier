package com.amplifier.repositories;

import java.util.Date;
import java.util.ArrayList;

import com.amplifier.models.Comment;

public interface CommentRepository {

    public ArrayList<Comment> findAllComments();

    public boolean createComment(Comment comment);

    public Comment findCommentById(int Id);

    public Comment findCommentByText(String comment_text); //implementation to find comment by .contains filter based on string input

    public Comment findCommentByAuthorId(int author_id);

    public Comment findCommentByImagePostId(int img_post_id);

    public Comment findCommentByCreationDate(Date comment_date);

    public ArrayList<Comment> listAllCommentsByCreationDate(Date comment_date);

    public boolean deleteCommentById(int Id);

    public boolean updateCommentById(int Id);



}
