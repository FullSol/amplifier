package com.amplifier.services;

import java.util.List;
import java.util.UUID;

import com.amplifier.models.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface UserService {
    public List<User> getAll();

    public boolean add(User user);

    public User getById(String id);

    public boolean edit(String userId, User user);

    public boolean remove(String id);

}
