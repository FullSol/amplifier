package com.amplifier.repositories;

import java.time.LocalDate;
import java.util.List;

import com.amplifier.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{

    @Query(value="SELECT * FROM user", nativeQuery = true)
    public List<User> findAll();

    @Query(value="INSERT INTO user (username,email,password,first_name,last_name,character_id,social_media_id,join_date,role_id,active) VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)")
    public boolean create(String username, String email, String password, String first_name, String last_name, int character_id, int id, LocalDate joinDate, int role_id, boolean active);

    @Modifying
    @Query(value="UPDATE user SET username=?1, email=?2, password=?3, first_name=?4, last_name=?5, character_id=?6, social_media_id=?7, join_date=?8,  role=?9, active=?10 WHERE id=?11", nativeQuery = true)
    public boolean update(String username, String email, String password, String first_name, String last_name, int character_id, int id, LocalDate joinDate, int role_id, boolean active);

    @Query(value="SELECT * FROM user where id=?1", nativeQuery = true)
    public User findById(int id);

    @Query(value="DELETE FROM user WHERE id=?1 LIMIT 1", nativeQuery = true)
    public boolean delete(int id);

}
