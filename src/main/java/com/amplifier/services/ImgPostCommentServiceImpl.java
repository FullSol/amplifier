package com.amplifier.services;

import java.util.List;
import java.util.UUID;

import com.amplifier.models.ImgPost;
import com.amplifier.models.ImgPostComment;
import com.amplifier.models.User;
import com.amplifier.repositories.ImgPostCommentRepository;
import com.amplifier.repositories.ImgPostRepository;
import com.amplifier.repositories.UserRepository;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImgPostCommentServiceImpl implements ImgPostCommentService {

  private Logger logger = Logger.getLogger(ImgPostCommentServiceImpl.class);

  @Autowired
  private ImgPostCommentRepository commentRepository;

  @Autowired
    UserRepository userRepository;

  @Autowired
    ImgPostRepository imgPostRepository;

  // @Override
  // public List<ImgPostComment> getAll() {
  //   return commentRepository.findAll();
  // }

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
    ImgPost imgPost = imgPostRepository.findById(imageId);
    return commentRepository.findByImgPostId(imgPost.getId());
  }

  @Override
  public boolean add(int postId, ImgPostComment comment) {
    ImgPost imgPost = imgPostRepository.findById(postId);
    logger.debug(imgPost);
    ImgPostComment target = commentRepository.findById(comment.getId());
    comment.setAuthor(comment.getAuthor());
    comment.setImgPost(imgPost);
    int pk = commentRepository.save(comment).getId();
    return (pk > 0) ? true : false;
  }

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
