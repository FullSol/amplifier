package com.amplifier.services;

import java.time.LocalDate;
import java.util.List;

import com.amplifier.models.Comment;
import com.amplifier.repositories.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

  @Autowired
  private CommentRepository commentRepository;

  @Override
  public List<Comment> getAll() {
    return commentRepository.findAll();
  }

  @Override
  public boolean add(Comment c) {
    int pk = commentRepository.save(c).getId();
    return (pk > 0) ? true : false;
  }

  @Override
  public Comment getById(int id) {
    return commentRepository.findCommentById(id);
  }
  
  @Override
  public Comment getByText(String s) {
    return commentRepository.findCommentByText(s);
  }

  @Override
  public Comment getByAuthorId(int id) {
    return commentRepository.findCommentByAuthorId(id);
  }

  @Override
  public Comment getByImageId(int id) {
    return commentRepository.findCommentByImagePostId(id);
  }

  @Override
  public Comment getByDate(LocalDate d) {
    return commentRepository.findCommentByCreationDate(d);
  }
  
  @Override
  public List<Comment> getAllByDate(LocalDate d) {
    return commentRepository.listAllCommentsByCreationDate(d);
  }
  
  @Override
  public boolean remove(int id) {
    return commentRepository.deleteCommentById(id);
  }
  
  @Override
  public boolean edit(int id) {
    return commentRepository.updateCommentById(id);
  }

}
