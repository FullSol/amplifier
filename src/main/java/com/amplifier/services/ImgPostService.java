package com.amplifier.services;

import java.util.List;

import com.amplifier.models.ImgPost;

public interface ImgPostService {
	
    public List<ImgPost> getAllImgPosts();

	public Object getImgPostById(int i);

	public Object deleteImgPost(ImgPost mockImgPostDeletion);

    public List<ImgPost> getAllImgPosts();

    public boolean createImgPost(ImgPost imgPost);

    public ImgPost getImgPostById(int Id);

    public boolean updateImgPost(ImgPost imgPost);

    public boolean deleteImgPostById(int Id);

}
