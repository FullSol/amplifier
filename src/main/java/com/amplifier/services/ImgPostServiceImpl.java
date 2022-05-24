package com.amplifier.services;

import java.util.List;

import com.amplifier.models.ImgPost;
import com.amplifier.repositories.ImgPostRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImgPostServiceImpl implements ImgPostService {

    @Autowired
    private ImgPostRepositoryImpl imgPostRepository;

    @Override
    public List<ImgPost> findAll() {
        return imgPostRepository.findAll();
    }

    @Override
    public boolean create(ImgPost imgPost) {
        return imgPostRepository.create(imgPost);
    }

    @Override
    public ImgPost findById(int id) {
        return imgPostRepository.findById(id);
    }

    @Override
    public boolean update(ImgPost imgPost) {
        return imgPostRepository.update(imgPost);
    }

    @Override
    public boolean deleteById(int id) {
        return imgPostRepository.deleteById(id);
    }

}
