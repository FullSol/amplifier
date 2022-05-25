package com.amplifier.services;

import java.util.List;

import com.amplifier.models.User;
import com.amplifier.repositories.UserRepository;
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
    public boolean add(User user) {
        return userRepository.create(user);
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public boolean edit(User user) {
        return false;
    }

    @Override
    public void remove(int id) {
        // TODO Auto-generated method stub
    }

    @Override
    public User login(String username, String password) {
        return null;
    }
}
