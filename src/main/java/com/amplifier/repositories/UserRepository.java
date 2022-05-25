package com.amplifier.repositories;

import java.util.List;

import com.amplifier.models.User;

public interface UserRepository {

    public List<User> findAll();

    public boolean create(User user);

}
