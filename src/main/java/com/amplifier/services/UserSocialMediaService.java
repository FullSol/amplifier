package com.amplifier.services;

import java.util.List;

import com.amplifier.models.SocialMedia;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface UserSocialMediaService {

    List<SocialMedia> getAll();

    SocialMedia getById(int id);

    boolean add(SocialMedia userSocialMedia);

    boolean edit(SocialMedia userSocialMedia);

    boolean remove(int id);


}
