package com.amplifier.services;

import java.util.List;

import com.amplifier.models.ImgPost;

public interface ImgPostService {

	public List<ImgPost> findAll();

	public boolean create(ImgPost imgPost);

	public ImgPost findById(int Id);

	public boolean update(ImgPost imgPost);

	public boolean deleteById(int Id);

}
