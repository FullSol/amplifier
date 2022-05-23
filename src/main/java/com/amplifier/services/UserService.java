package com.amplifier.services;

import java.util.List;

import com.amplifier.models.User;

public interface UserService {
    public List<User> getAll();

    public boolean create(User user);

    public Object createUser(User mockUserCreation);
}
