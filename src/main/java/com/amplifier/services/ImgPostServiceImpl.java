package com.amplifier.services;

import java.util.List;

import com.amplifier.models.ImgPost;
import com.amplifier.repositories.ImgPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImgPostServiceImpl implements ImgPostService {

    @Autowired
    private ImgPostRepository imgPostRepository;

    @Override
    public List<ImgPost> getAllImgPosts() {
        return imgPostRepository.findAll();
    }

    @Override
    public boolean createImgPost(ImgPost imgPost) {
        return imgPostRepository.create(imgPost);
    }

    @Override
    public ImgPost getImgPostById(int id) {
        return imgPostRepository.findById(id);
    }

    @Override
    public boolean updateImgPost(ImgPost imgPost) {
        return imgPostRepository.update(imgPost);
    }

    @Override
    public boolean deleteImgPostById(int id) {
        return imgPostRepository.deleteById(id);
    }

}
