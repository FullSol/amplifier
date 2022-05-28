package com.amplifier.repositories;

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

    @Query(value = "SELECT * FROM img_post_comments WHERE id = ?1", nativeQuery = true)
    public Comment findById(int id);

    @Query(value = "SELECT * FROM img_post_comments WHERE author_id = ?1", nativeQuery = true)
    public Comment findByAuthorId(int authorId);

    @Query(value = "SELECT * FROM img_post_comments WHERE img_post_id = ?1", nativeQuery = true)
    public Comment findImagePostId(int imgPostId);

    @Query(value = "UPDATE img_post_comments SET comment_text, comment_text = ?1", nativeQuery= true)
    public boolean update(String commentText);

    @Query(value = "DELETE * FROM img_post_comments WHERE id = ?1", nativeQuery = true)
    public boolean delete(int id);

}
