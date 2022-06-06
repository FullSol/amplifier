package com.amplifier.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amplifier.models.ImgPost;
import com.amplifier.models.UserJwtDTO;

@Service
@Transactional
public interface ImgPostService {

	public List<ImgPost> getByAuthorId(String authorId);

	public List<ImgPost> getAll();

	public boolean add(UserJwtDTO userDTO, ImgPost imgPost);

	public ImgPost getById(int id);

	public boolean edit(int id, ImgPost imgPost);

	public boolean remove(ImgPost imgPost);
}
