package com.amplifier.repositories;

import com.amplifier.models.UserSocialMedia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSocialMediaRepository extends JpaRepository<UserSocialMedia, Integer>{

    //UserSocialMedia findById(int userId, int mediaId);
    UserSocialMedia findById(int id);

    boolean create(UserSocialMedia userSocialMedia);

    boolean update(UserSocialMedia userSocialMedia);

    boolean delete(int id);

}
