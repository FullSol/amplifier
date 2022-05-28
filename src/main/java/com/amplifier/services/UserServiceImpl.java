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
        int pk = repository.save(user).getId();
        return (pk > 0) ? true : false;
    }

    @Override
    public User getById(int id) {
        return repository.findById(id);
    }

    @Override
    public boolean edit(User user) {
        User target = repository.findById(user.getId());

        target.setUsername(user.getUsername());
        target.setEmail(user.getUsername());
        target.setPassword(user.getUsername());
        target.setFirstName(user.getUsername());
        target.setLastName(user.getUsername());
        target.setBlizzardAccount(user.getBlizzardAccount());
        target.setSocialMedia(user.getSocialMedia());
        target.setJoinDate(user.getJoinDate());
        target.setRole(user.getRole());
        target.setActive(user.isActive());

        return (repository.save(target) != null) ? true : false;
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
