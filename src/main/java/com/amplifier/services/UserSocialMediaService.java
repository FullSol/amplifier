package com.amplifier.services;

import com.amplifier.models.UserSocialMedia;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface UserSocialMediaService {

    //UserSocialMedia getById(int userId, int mediaId);
    UserSocialMedia getById(int mediaId);

    boolean add(UserSocialMedia userSocialMedia);

    boolean edit(UserSocialMedia userSocialMedia);

    boolean remove(int id);

}
