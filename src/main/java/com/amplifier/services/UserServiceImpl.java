package com.amplifier.services;

import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.User;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public boolean createUser(User mockUserCreation) {
        return false;
    }

    public List<User> getAllUsers() {
        // Retuning a blank list test is meant to fail at this point...
        return new ArrayList<>();
    }
}
