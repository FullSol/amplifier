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

    @Query("SELECT * FROM user_blizzard_accounts")
    public List<UserBlizzardAccount> findAll();

    @Query("SELECT u from user_blizzard_accounts u where u.id = ?1")
    public UserBlizzardAccount findById(int id);

    @Modifying
    @Query("UPDATE user_blizzard_accounts u set u.account_name = ?1 where id = ?2")
    public boolean update(String accountName, int id);

    @Query("DELETE * FROM user_blizzard_accounts where id=?1")
    public boolean delete(int id);

}
