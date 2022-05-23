package com.amplifier.services;

import java.util.List;

import com.amplifier.models.User;
import com.amplifier.repositories.UserRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean create(User user) {
        return userRepository.create(user);
    }

    @Override
    public boolean createUser(User mockUserCreation) {
        return false;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public boolean updateUser(User mockUserModification) {
        return false;
    }
}
