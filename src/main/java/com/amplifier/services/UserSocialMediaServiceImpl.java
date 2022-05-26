package com.amplifier.services;

import com.amplifier.models.UserSocialMedia;
import com.amplifier.repositories.UserRepository;
import com.amplifier.repositories.UserSocialMediaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserSocialMediaServiceImpl implements UserSocialMediaService {

    @Autowired
    private UserSocialMediaRepository socialMediaRepository;

    // @Override
    // public UserSocialMedia getById(int userId, int mediaId) {
    //     return null;
    // }

    @Override
    public UserSocialMedia getById(int id) {
        return socialMediaRepository.findById(id);
    }

    @Override
    public boolean add(UserSocialMedia userSocialMedia) {
        int pk = socialMediaRepository.save(userSocialMedia).getId();
        return (pk > 0) ? true : false;
    }

    @Override
    public boolean edit(UserSocialMedia userSocialMedia) {
        UserSocialMedia target = socialMediaRepository.findById(userSocialMedia.getId());
        target.setTwitterLink(userSocialMedia.getTwitterLink());
        target.setFacebookLink(userSocialMedia.getFacebookLink());
        target.setInstagramLink(userSocialMedia.getInstagramLink());
        return (socialMediaRepository.save(target) != null) ? true : false;
    }

    @Override
    public boolean remove(int id) {
        return socialMediaRepository.delete(id);
    }


}
