package com.amplifier.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CharacterRepository extends JpaRepository<Character, Integer> {

    @Query(value = "SELECT * FROM user_character", nativeQuery = true)
    public List<Character> findAll();

    @Query(value = "INSERT INTO user_character (realm, name) VALUES (?1, ?2)", nativeQuery = true)
    public boolean create(Character character);

    @Query(value = "SELECT * FROM user_character WHERE id=?1")
    public Character findById(int id);

    @Query(value = "UDPATE user_character SET realm=?1, name = ?2 WHERE id = ?3", nativeQuery = true)
    public boolean update(Character character);

    @Query(value = "DELETE * FROM user_character WHERE id=?1", nativeQuery = true)
    public boolean deleteById(int id);

}
