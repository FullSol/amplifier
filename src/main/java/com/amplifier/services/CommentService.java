package com.amplifier.services;

import java.time.LocalDate;
import java.util.List;

import com.amplifier.models.Comment;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface CommentService {

  public boolean add(Comment c);
  
  public Comment getById(int id);

  public Comment getByAuthorId(int id);

  public Comment getByImageId(int id);

  public Comment getByDate(LocalDate d);

  public Comment getByText(String comment_text);
  
  public boolean edit(int id);
  
  public boolean remove(int id);
  
  public List<Comment> getAll();
  
  public List<Comment> getAllByDate(LocalDate d);
  
}
