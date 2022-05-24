package com.amplifier.services;

import java.util.List;

import com.amplifier.models.ImgPost;

import com.amplifier.repositories.ImgPostRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImgPostServiceImpl implements ImgPostService{

    @Autowired
    private ImgPostRepositoryImpl imgPostRepository;

    @Override
    public List<ImgPost> getAllImgPosts() {
        return imgPostRepository.findAll();
    }

    @Override
    public boolean createImgPost(ImgPost imgPost) {
        return imgPostRepository.create(imgPost);

    }

    @Override
    public ImgPost getImgPostById(int Id) {
        return imgPostRepository.findById(Id);
    }

    @Override
    public boolean updateImgPost(ImgPost imgPost) {
        return imgPostRepository.update(imgPost);
    }

    @Override
    public boolean deleteImgPostById(int Id) {
        return imgPostRepository.deleteById(Id);
    }
    
}
