package com.amplifier.services;

import java.util.List;

import com.amplifier.models.ImgPost;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface ImgPostService {

	public List<ImgPost> getAll();

	public boolean add(ImgPost imgPost);

	public ImgPost getById(int id);

	public boolean edit(ImgPost imgPost);

	public boolean remove(int id);
}
