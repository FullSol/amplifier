package com.amplifier.services;

import java.util.List;

import com.amplifier.models.ImgPostComment;
import com.amplifier.repositories.ImgPostCommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImgPostCommentServiceImpl implements ImgPostCommentService {

  @Autowired
  private ImgPostCommentRepository repository;

  @Override
  public List<ImgPostComment> getAll() {
    return repository.findAll();
  }

  @Override
  public ImgPostComment getById(int id) {
    return repository.findById(id);
  }

  @Override
  public ImgPostComment getByAuthorId(int authorId) {
    return repository.findByAuthorId(authorId);
  }

  @Override
  public ImgPostComment getByImagePostId(int imageId) {
    return repository.findImagePostId(imageId);
  }

  @Override
  public boolean add(ImgPostComment comment) {
    int pk = repository.save(comment).getId();
    return (pk > 0) ? true : false;
  }

  @Override
  public boolean edit(ImgPostComment comment) {
    ImgPostComment target = repository.findById(comment.getId());

    target.setCommentText(comment.getCommentText());
    target.setImgPost(comment.getImgPost());
    target.setAuthor(comment.getAuthor());
    target.setCommentDate(comment.getCommentDate());

    return (repository.save(target) != null) ? true : false;
  }

  @Override
  public boolean remove(int id) {
    return repository.delete(id);
  }

}
