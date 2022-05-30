package com.amplifier.services;

import java.util.List;

import javax.transaction.Transactional;

import com.amplifier.models.ImgPost;
import com.amplifier.repositories.ImgPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImgPostServiceImpl implements ImgPostService {

    @Autowired
    private ImgPostRepository imgPostRepository;

    @Override
    public List<ImgPost> getAll() {
        return imgPostRepository.findAll();
    }

    @Override
    public boolean add(ImgPost imgPost) {
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
