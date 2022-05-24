package com.amplifier.repositories;

import java.util.List;

import com.amplifier.models.ImgPost;

public interface ImgPostRepository {
    public List<ImgPost> findAll();

    public boolean create(ImgPost imgPost);

    public ImgPost findById(int id);

    public boolean update(ImgPost imgPost);

    public boolean deleteById(int id);
}
