package com.amplifier.services;

import java.util.List;

import com.amplifier.models.ImgPost;

public interface ImgPostService {
	public List<ImgPost> getAllImgPosts();

	public List<ImgPost> getAll();

	public boolean add(ImgPost imgPost);

	public ImgPost getById(int Id);

	public boolean edit(ImgPost imgPost);

	public boolean remove(int Id);

	public boolean deleteImgPostById(int id);
}
