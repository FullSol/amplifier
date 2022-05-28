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
  private CommentRepository repository;

  @Override
  public List<Comment> getAll() {
    return repository.findAll();
  }

  @Override
  public Comment getById(int id) {
    return repository.findById(id);
  }

  @Override
  public Comment getByAuthorId(int authorId) {
    return repository.findByAuthorId(authorId);
  }

  @Override
  public Comment getByImagePostId(int imageId) {
    return repository.findImagePostId(imageId);
  }

  @Override
  public boolean add(Comment comment) {
    int pk = repository.save(comment).getId();
    return (pk > 0) ? true : false;
  }

  @Override
  public boolean edit(Comment comment) {
    Comment target = repository.findById(comment.getId());
    
    target.setCommentText(comment.getCommentText());
    target.setImgPostId(comment.getImgPostId());
    target.setAuthor(comment.getAuthor());
    target.setCommentDate(comment.getCommentDate());

    return (repository.save(target) != null) ? true : false;
  }

  @Override
  public boolean remove(int id) {
    return repository.delete(id);
  }

}
