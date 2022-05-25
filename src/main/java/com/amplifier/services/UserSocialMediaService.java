package com.amplifier.services;

import com.amplifier.models.UserSocialMedia;

public interface UserSocialMediaService {

    boolean deleteUserSocialMedia(UserSocialMedia userSocialMedia);

    boolean updateUser(UserSocialMedia userSocialMedia);

    UserSocialMedia getUserSocialMediaById(int userId, int mediaId);

    boolean addUserSocialMedia(UserSocialMedia userSocialMedia);

}
