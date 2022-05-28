package com.amplifier.services;

import java.time.LocalDate;
import java.util.List;

import com.amplifier.models.Comment;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface CommentService {

  public List<Comment> getAll();

  public Comment getById(int id);

  public Comment getByAuthorId(int authorId);

  public Comment getByImagePostId(int imageId);

  public boolean add(Comment comment);

  public boolean edit(Comment comment);

  public boolean remove(int id);

}
