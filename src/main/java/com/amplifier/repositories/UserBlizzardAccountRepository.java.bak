package com.amplifier.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amplifier.models.UserBlizzardAccount;

@Repository
@Transactional
public interface UserBlizzardAccountRepository extends JpaRepository<UserBlizzardAccount, Integer> {

    @Query(value = "SELECT * FROM user_blizzard_accounts", nativeQuery = true)
    public List<UserBlizzardAccount> findAll();

    @Query(value = "SELECT u from user_blizzard_accounts u WHERE u.id = ?1", nativeQuery = true)
    public UserBlizzardAccount findById(int id);

    @Query(value = "SELECT * from user_blizzard_accounts WHERE battle_tag = ?1", nativeQuery = true)
    public UserBlizzardAccount findByBattleTag(String battleTag);

    @Query(value = "SELECT * FROM user_blizzard_accounts WHERE user_id = ?1", nativeQuery = true)
    public UserBlizzardAccount findByUserId(UUID userId);

    @Modifying
    @Query(value = "UPDATE user_blizzard_accounts u SET u.battle_tag = ?1 where id = ?2", nativeQuery = true)
    public boolean update(String battleTag, int id);

    @Modifying
    @Query(value = "DELETE FROM user_blizzard_accounts WHERE id=?1", nativeQuery = true)
    public void delete(int id);

}
