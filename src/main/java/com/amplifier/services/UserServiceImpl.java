package com.amplifier.services;

import java.util.List;
import java.util.UUID;

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
        UUID pk = repository.save(user).getId();
        return (pk != null) ? true : false;
    }

    @Override
    public User getById(String id) {
        UUID idAsUUID = UUID.fromString(id);
        return repository.findById(id);
    }

    @Override
    public boolean edit(User user) {
        User target = repository.findById(user.getId().toString());

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
    public boolean remove(String id) {
        UUID idAsUUID = UUID.fromString(id);
        return repository.delete(id);
    }

    // @Override
    // public User login(String username, String password) {
    // return repository.login(username, password);
    // }
}
