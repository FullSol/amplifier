package com.amplifier.repositories;

import java.util.List;

import com.amplifier.models.User;

public interface UserDAO {

    public List<User> findAll();
}
