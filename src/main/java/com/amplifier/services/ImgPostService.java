package com.amplifier.services;

import java.util.List;

import com.amplifier.models.ImgPost;

public interface ImgPostService {
	public List<ImgPost> getAllImgPosts();

	public boolean createImgPost(ImgPost imgPost);

	public ImgPost getImgPostById(int id);

	public boolean updateImgPost(ImgPost imgPost);

	public boolean deleteImgPostById(int id);
}
