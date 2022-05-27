package com.amplifier.services;

import java.util.List;

import com.amplifier.models.User;
import com.amplifier.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean add(User user) {
        return repository.create(user);
    }

    @Override
    public User getById(int id) {
        return repository.findById(id);
    }

    @Override
    public boolean edit(User user) {
        return repository.update(user);
    }

    @Override
    public boolean remove(int id) {
        return repository.delete(id);
    }

    @Override
    public User login(String username, String password) {
        return repository.login(username, password);
    }
}
