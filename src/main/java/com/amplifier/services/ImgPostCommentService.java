package com.amplifier.services;

import java.util.List;

import com.amplifier.models.ImgPostComment;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface ImgPostCommentService {

  public List<ImgPostComment> getAll();

  public ImgPostComment getById(int id);

  public List<ImgPostComment> getByAuthorId(String authorId);

  public List<ImgPostComment> getByImagePostId(int imageId);

  public boolean add(String authorId, ImgPostComment comment);

  public boolean edit(int id, ImgPostComment comment);

  public boolean remove(ImgPostComment comment);

}
