package com.amplifier.services;

import java.util.List;
import java.util.UUID;

import com.amplifier.models.ImgPostComment;
import com.amplifier.models.User;
import com.amplifier.repositories.ImgPostCommentRepository;
import com.amplifier.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImgPostCommentServiceImpl implements ImgPostCommentService {

  @Autowired
  private ImgPostCommentRepository commentRepository;

  @Autowired
    UserRepository userRepository;

  @Override
  public List<ImgPostComment> getAll() {
    return commentRepository.findAll();
  }

  @Override
  public ImgPostComment getById(int id) {
    return commentRepository.findById(id);
  }

  @Override
  public List<ImgPostComment> getByAuthorId(String authorId) {
    UUID userUUID = UUID.fromString(authorId);
    User user = userRepository.findById(userUUID).get();
    return commentRepository.findByAuthorId(user.getId());
  }

  @Override
  public List<ImgPostComment> getByImagePostId(int imageId) {
    return commentRepository.findByImgPostId(imageId);
  }

  @Override
  public boolean add(String authorId, ImgPostComment comment) {
    UUID userUUID = UUID.fromString(authorId);
    User user = userRepository.findById(userUUID).get();
    ImgPostComment target = commentRepository.findById(comment.getId());
    comment.setAuthor(user);
    int pk = commentRepository.save(comment).getId();
    return (pk > 0) ? true : false;
  }

  /*
    @Override
    public boolean add(User user) {
        UUID pk = repository.save(user).getId();
        return (pk != null) ? true : false;
    }
  */

  @Override
  public boolean edit(int id, ImgPostComment comment) {
    ImgPostComment target = commentRepository.findById(id);

    target.setCommentText(comment.getCommentText());
    target.setImgPost(comment.getImgPost());
    target.setAuthor(comment.getAuthor());
    target.setCommentDate(comment.getCommentDate());

    return (commentRepository.save(target) != null) ? true : false;
  }

  @Override
  public boolean remove (ImgPostComment comment) {
    try {
      commentRepository.delete(comment);
    }
    catch (Exception e) {
      return false;
    }
    return true;
  }

}
