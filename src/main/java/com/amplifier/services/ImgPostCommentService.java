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

  public ImgPostComment getByAuthorId(int authorId);

  public ImgPostComment getByImagePostId(int imageId);

  public boolean add(ImgPostComment comment);

  public boolean edit(ImgPostComment comment);

  public boolean remove(int id);

}
