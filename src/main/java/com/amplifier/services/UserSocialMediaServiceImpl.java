package com.amplifier.services;

import java.util.List;

import com.amplifier.models.SocialMedia;
import com.amplifier.repositories.UserSocialMediaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserSocialMediaServiceImpl implements UserSocialMediaService {

    @Autowired
    private UserSocialMediaRepository repository;

    @Override
    public List<SocialMedia> getAll() {
        return repository.findAll();
    }

    @Override
    public SocialMedia getById(int id) {
        return repository.findById(id);
    }

    @Override
    public boolean add(SocialMedia userSocialMedia) {
        int pk = repository.save(userSocialMedia).getSocialMediaId();
        return (pk > 0) ? true : false;
    }

    @Override
    public boolean edit(SocialMedia userSocialMedia) {
        SocialMedia target = repository.findById(userSocialMedia.getSocialMediaId());
        target.setTwitterLink(userSocialMedia.getTwitterLink());
        target.setFacebookLink(userSocialMedia.getFacebookLink());
        target.setInstagramLink(userSocialMedia.getInstagramLink());
        return (repository.save(target) != null) ? true : false;
    }

    @Override
    public boolean remove(int id) {
        return repository.delete(id);
    }




}
