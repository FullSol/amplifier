package com.amplifier.repositories;

import java.util.ArrayList;
import java.util.Date;

import com.amplifier.models.Comment;

import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository {

    @Override
    public ArrayList<Comment> findAllComments() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean createComment(Comment comment) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Comment findCommentById(int Id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Comment findCommentByText(String comment_text) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Comment findCommentByAuthorId(int author_id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Comment findCommentByImagePostId(int img_post_id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Comment findCommentByCreationDate(Date comment_date) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Comment> listAllCommentsByCreationDate(Date comment_date) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteCommentById(int Id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateCommentById(int Id) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
