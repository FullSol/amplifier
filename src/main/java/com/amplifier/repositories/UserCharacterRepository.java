package com.amplifier.repositories;

import java.util.List;

import com.amplifier.models.UserCharacter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserCharacterRepository extends JpaRepository<UserCharacter, Integer> {

    @Query(value = "SELECT * FROM user_character", nativeQuery = true)
    public List<UserCharacter> findAll();

    @Query(value = "SELECT * FROM user_character WHERE id=?1", nativeQuery = true)
    public UserCharacter findById(int id);

    @Query(value = "UDPATE user_character SET realm=?1, name = ?2 WHERE id = ?3", nativeQuery = true)
    public boolean update(String realm, String name, int id);

    @Query(value = "DELETE * FROM user_character WHERE id=?1", nativeQuery = true)
    public boolean delete(int id);

}
