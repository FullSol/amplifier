package com.amplifier.services;

import java.util.List;

import com.amplifier.models.ImgPost;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface ImgPostService {

	public List<ImgPost> getByAuthorId(String authorId);

	public boolean add(String userId, ImgPost imgPost);

	public ImgPost getById(int id);

	public boolean edit(int id, ImgPost imgPost);

	public boolean remove(ImgPost imgPost);
}
