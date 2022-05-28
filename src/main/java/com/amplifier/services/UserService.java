package com.amplifier.services;

import java.util.List;

import com.amplifier.models.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface UserService {
    public List<User> getAll();

    public boolean add(User user);

    public User getById(int id);

    public boolean edit(User user);

    public boolean remove(int id);

    public User login(String username, String password);
}
