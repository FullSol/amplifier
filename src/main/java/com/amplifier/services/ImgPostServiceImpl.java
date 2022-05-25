package com.amplifier.services;

import java.util.List;

import com.amplifier.models.ImgPost;
import com.amplifier.repositories.ImgPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImgPostServiceImpl implements ImgPostService {

    @Autowired
    private ImgPostRepository imgPostRepository;

    @Override
    public List<ImgPost> findAll() {
        return imgPostRepository.findAll();
    }

    @Override
    public boolean createImgPost(ImgPost imgPost) {
        int pk = imgPostRepository.save(imgPost).getId();
        return (pk > 0) ? true : false;
    }

    @Override
    public ImgPost findById(int id) {
        return imgPostRepository.findById(id);
    }

    @Override
    public boolean updateImgPost(ImgPost imgPost) {
        ImgPost target = imgPostRepository.findById(imgPost.getId());
        target.setImgLocation(imgPost.getImgLocation());
        target.setAuthor(imgPost.getAuthor());
        return (imgPostRepository.save(target) != null) ? true : false;
    }

    @Override
    public boolean deleteById(int id) {
        return imgPostRepository.deleteById(id);
    }

}
