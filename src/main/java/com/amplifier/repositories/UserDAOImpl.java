package com.amplifier.repositories;

import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.User;

public class UserDAOImpl implements UserDAO {

    public List<User> findAll() {
        // Retuning a blank list test is meant to fail at this point...
        return new ArrayList<>();
    }
}
