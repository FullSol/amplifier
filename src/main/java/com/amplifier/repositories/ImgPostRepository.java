package com.amplifier.repositories;

import java.util.List;

import com.amplifier.models.ImgPost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ImgPostRepository extends JpaRepository<ImgPost, Integer> {

    @Query(value = "SELECT * FROM ImgPosts", nativeQuery = true)
    public List<ImgPost> findAll();

    @Query(value = "INSERT INTO ImgPosts (img_location, author_id) VALUES(?1, ?2)", nativeQuery = true)
    public boolean create(String imgLocation, int authorId);

    @Query(value = "SELECT * FROM ImgPosts WHERE id=?1")
    public ImgPost findById(int id);

    @Query(value = "UPDATE ImgPosts SET img_location=?1, author_id=?2 WHERE id=?3", nativeQuery = true)
    public boolean update(String imgocation, int authorId, int id);

    @Query(value = "DELETE * FROM ImgPosts WHERE id=?1", nativeQuery = true)
    public boolean deleteById(int id);
}
