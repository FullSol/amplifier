package com.amplifier.services;

import java.util.List;
import java.util.UUID;

import com.amplifier.models.User;
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
    private UserSocialMediaRepository repository;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    public UserSocialMediaServiceImpl(UserSocialMediaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserSocialMedia> getAll() {
        return repository.findAll();
    }

    @Override
    public UserSocialMedia getByUserId(String userId) {
        UUID userUUID = UUID.fromString(userId);
        User user = userRepo.findById(userUUID).get();
        return repository.findByUser(user.getId().toString());
    }

    @Override
    public boolean add(UserSocialMedia userSocialMedia) {
        int pk = repository.save(userSocialMedia).getId();
        return (pk > 0) ? true : false;
    }

    @Override
    public boolean edit(UserSocialMedia userSocialMedia) {
        UserSocialMedia target = repository.findById(userSocialMedia.getId());

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
