package com.amplifier.services;

import java.util.List;

import com.amplifier.models.User;

public interface UserService {
    public List<User> getAll();

    public boolean create(User user);

    public boolean createUser(User user);

    public User getUserById(int id);

    public List<User> getAllUsers();

    public boolean updateUser(User user);

    public boolean deleteUser(User user);
}
