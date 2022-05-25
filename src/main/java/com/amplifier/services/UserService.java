package com.amplifier.services;

import java.util.List;

import com.amplifier.models.User;

public interface UserService {
    public List<User> getAll();

    public boolean add(User user);

    public User getById(int id);

    public List<User> getAll();

    public boolean edit(User user);

    public boolean remove(User user);
}
