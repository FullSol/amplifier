package com.amplifier.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import com.amplifier.models.User;
import com.amplifier.models.UserBlizzardAccount;
import com.amplifier.models.UserRole;
import com.amplifier.models.UserSocialMedia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    public List<User> findAll();

    @Modifying
    @Query(value = "UPDATE users SET username=?1, email=?2, password=?3, first_name=?4, last_name=?5, blizzard_account_id=?6, social_media_id=?7, join_date=?8, role=?9, active=?10 WHERE id=?11", nativeQuery = true)
    public boolean update(String username, String email, String password, String firstName, String lastName,
            UserBlizzardAccount blizzardAccount, UserSocialMedia socialMedia, LocalDate joinDate, UserRole role,
            boolean active, UUID id);

    @Query(value = "SELECT * FROM users WHERE id=?1", nativeQuery = true)
    public Optional<User> findById(UUID id);

    @Modifying
    @Query(value = "DELETE FROM users WHERE id=?1", nativeQuery = true)
    public void delete(UUID id);

}
