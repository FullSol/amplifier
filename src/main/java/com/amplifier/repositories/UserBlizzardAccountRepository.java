package com.amplifier.repositories;

import java.util.List;

import com.amplifier.models.UserBlizzardAccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserBlizzardAccountRepository extends JpaRepository<UserBlizzardAccount, Integer> {

    @Query(value = "SELECT * FROM user_blizzard_accounts", nativeQuery = true)
    public List<UserBlizzardAccount> findAll();

    @Query(value = "SELECT u from user_blizzard_accounts u WHERE u.id = ?1", nativeQuery = true)
    public UserBlizzardAccount findById(int id);

    @Modifying
    @Query(value = "UPDATE user_blizzard_accounts u SET u.account_name = ?1 where id = ?2", nativeQuery = true)
    public boolean update(String accountName, int id);

    @Query(value = "DELETE * FROM user_blizzard_accounts WHERE id=?1", nativeQuery = true)
    public boolean delete(int id);

}
