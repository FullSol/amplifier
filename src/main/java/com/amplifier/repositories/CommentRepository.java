package com.amplifier.repositories;

import java.time.LocalDate;
import java.util.ArrayList;

import com.amplifier.models.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Integer>{

    @Query (value = "SELECT * FROM img_post_comments", nativeQuery = true)
    public ArrayList<Comment> findAll();

    public ArrayList<Comment> listAllCommentsByCreationDate(LocalDate comment_date);

    @Query(value = "SELECT * FROM img_post_comments WHERE id = ?1", nativeQuery = true)
    public Comment findById(int Id);

    public Comment findCommentByText(String comment_text); //implementation to find comment by .contains filter based on string input

    public Comment findCommentByAuthorId(int author_id);

    public Comment findCommentByImagePostId(int img_post_id);

    public Comment findCommentByCreationDate(LocalDate comment_date);

    public boolean create(Comment comment);

    public boolean updateCommentById(int id);

    @Query(value = "DELETE * FROM img_post_comments WHERE id'?1", nativeQuery = true)
    public boolean deleteById(int id);

}
