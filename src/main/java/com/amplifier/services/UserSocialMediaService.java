package com.amplifier.services;

import com.amplifier.models.UserSocialMedia;

public interface UserSocialMediaService {

    boolean deleteUserSocialMedia(UserSocialMedia userSocialMedia);

    boolean updateUser(UserSocialMedia userSocialMedia);

    UserSocialMedia getUserSocialMediaById(int id);

    boolean addUserSocialMedia(UserSocialMedia userSocialMedia);

}
