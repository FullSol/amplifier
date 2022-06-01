package com.amplifier.repositories;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import com.amplifier.models.UserSocialMedia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserSocialMediaRepository extends JpaRepository<UserSocialMedia, Integer> {

	@Query(value = "SELECT * FROM users_social_media", nativeQuery = true)
	public List<UserSocialMedia> findAll();

	@Query(value = "SELECT * FROM users_social_media WHERE id=?1", nativeQuery = true)
	public UserSocialMedia findByUser(UUID id);

	@Modifying
	@Query(value = "UPDATE users_social_media SET twitter_link=?1, facebook_link=?2, instagram_link=?3 WHERE id=?4", nativeQuery = true)
	public boolean update(String twitterLink, String facebookLink, String instagramLink, int id);

	@Modifying
	@Query(value = "DELETE * FROM users_social_media WHERE id=?1", nativeQuery = true)
	public boolean delete(int id);

}
