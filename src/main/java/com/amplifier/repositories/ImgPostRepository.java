package com.amplifier.repositories;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import com.amplifier.models.ImgPost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ImgPostRepository extends JpaRepository<ImgPost, Integer> {

    @Query(value = "SELECT * FROM img_posts WHERE author_id = ?1", nativeQuery = true)
    public List<ImgPost> findAllByAuthor(UUID authorId);

    @Query(value = "SELECT * FROM img_posts WHERE id=?1", nativeQuery = true)
    public ImgPost findById(int id);

    @Query(value = "UPDATE img_posts SET img_caption=?1, img_location=?2 WHERE id=?3", nativeQuery = true)
    public boolean update(String imgCaption, String imgLocation, int id);

    @Query(value = "DELETE * FROM img_posts WHERE id=?1", nativeQuery = true)
    public boolean delete(int id);
}
