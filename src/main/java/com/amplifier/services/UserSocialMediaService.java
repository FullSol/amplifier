package com.amplifier.services;

import java.util.List;

import com.amplifier.models.UserSocialMedia;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface UserSocialMediaService {

    List<UserSocialMedia> getAll();

    UserSocialMedia getByUserId(String id);

    boolean add(String userId, UserSocialMedia userSocialMedia);

    boolean edit(String userId, UserSocialMedia userSocialMedia);

    boolean remove(String userId);

}
