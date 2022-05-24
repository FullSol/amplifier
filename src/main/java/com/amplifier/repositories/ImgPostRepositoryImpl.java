package com.amplifier.repositories;

import java.util.List;

import com.amplifier.models.ImgPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ImgPostRepositoryImpl implements ImgPostRepository {

    @Autowired
    private ImgPost imgPost;

    @Override
    public List<ImgPost> findAll() {
        return null;
    }

    @Override
    public boolean create(ImgPost imgPost) {
        return false;
    }

    @Override
    public ImgPost findById(int id) {
        return null;
    }

    @Override
    public boolean update(ImgPost imgPost) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
