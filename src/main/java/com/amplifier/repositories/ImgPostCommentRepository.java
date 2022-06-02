package com.amplifier.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.amplifier.models.ImgPostComment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ImgPostCommentRepository extends JpaRepository<ImgPostComment, Integer> {

    @Query(value = "SELECT * FROM img_post_comments", nativeQuery = true)
    public ArrayList<ImgPostComment> findAll();

    @Query(value = "SELECT * FROM img_post_comments WHERE id = ?1", nativeQuery = true)
    public ImgPostComment findById(int id);

    @Query(value = "SELECT * FROM img_post_comments WHERE author_id = ?1", nativeQuery = true)
    public List<ImgPostComment> findByAuthorId(UUID authorId);

    @Query(value = "SELECT * FROM img_post_comments WHERE img_post_id = ?1", nativeQuery = true)
    public List<ImgPostComment> findByImgPostId(int imgPostId);

    @Modifying
    @Query(value = "UPDATE img_post_comments SET comment_text = ?1", nativeQuery = true)
    public boolean update(String commentText);

    //can comment this delete one out
    @Query(value = "DELETE * FROM img_post_comments WHERE id = ?1", nativeQuery = true)
    public boolean delete(int id);

}
