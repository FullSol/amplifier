package com.amplifier.repositories;

import java.util.List;

import com.amplifier.models.SocialMedia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UserSocialMediaRepository extends JpaRepository<SocialMedia, Integer>{

	@Query(value = "SELECT * FROM users_social_media", nativeQuery = true)
	public List<SocialMedia> findAll();

	@Modifying
	@Query(value = "INSERT INTO users_social_media (twitter_link, facebook_link, instagram_link) VALUES (?1, ?2, ?3)", nativeQuery = true)
	public boolean create(String twitterLink, String facebookLink, String instagramLink);

	@Query(value = "SELECT * FROM users_social_media WHERE id=?1", nativeQuery = true)
	public SocialMedia findById(int id);

	@Modifying
	@Query(value = "UPDATE users_social_media SET twitter_link=?1, facebook_link=?2, instagram_link=?3 WHERE id=?4", nativeQuery = true)
	public boolean update(String twitterLink, String facebookLink, String instagramLink, int id);

	@Modifying
	@Query(value = "DELETE * FROM users_social_media WHERE id=?1", nativeQuery = true)
	public boolean delete(int id);

}
