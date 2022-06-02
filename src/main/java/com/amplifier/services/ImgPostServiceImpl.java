package com.amplifier.services;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import com.amplifier.models.ImgPost;
import com.amplifier.models.User;
import com.amplifier.repositories.ImgPostRepository;
import com.amplifier.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImgPostServiceImpl implements ImgPostService {

    @Autowired
    private ImgPostRepository imgPostRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<ImgPost> getByAuthorId(String authorId) {
        UUID userUUID = UUID.fromString(authorId);
        User user = userRepository.findById(userUUID).get();
        return imgPostRepository.findAllByAuthor(user.getId());
    }

    @Override
    public boolean add(String userId, ImgPost imgPost) {
        UUID userUUID = UUID.fromString(userId);
        User user = userRepository.findById(userUUID).get();
        ImgPost target = imgPostRepository.findById(imgPost.getId());
        imgPost.setAuthor(user);
        int pk = imgPostRepository.save(imgPost).getId();
        return (pk > 0) ? true : false;
    }

    @Override
    public ImgPost getById(int id) {
        return imgPostRepository.findById(id);
    }

    @Override
    public boolean edit(ImgPost imgPost) {
        ImgPost target = imgPostRepository.findById(imgPost.getId());

        target.setImgLocation(imgPost.getImgLocation());
        target.setAuthor(imgPost.getAuthor());

        return (imgPostRepository.save(target) != null) ? true : false;
    }

    @Override
    public boolean remove(int id) {
        return imgPostRepository.delete(id);
    }

}
