package com.amplifier.services;

import java.util.List;

import com.amplifier.models.User;

public interface UserService {
    public List<User> getAll();

    public boolean create(User user);

    public boolean createUser(User mockUserCreation);

    public User getUserById(int id);

    public List<User> getAllUsers();

    public boolean updateUser(User mockUserModification);

    public boolean deleteCandy(User mockUserDeletion);
}
