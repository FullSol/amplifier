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

    public UserServiceImpl(UserRepository repo) {
    }

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
        return repository.findById(idAsUUID).get();
    }

    @Override
    public boolean edit(String userId, User user) {
        UUID userUUID = UUID.fromString(userId);
        User target = repository.findById(userUUID).get();

        target.setUsername(user.getUsername());
        target.setEmail(user.getEmail());
        target.setPassword(user.getPassword());
        target.setFirstName(user.getFirstName());
        target.setLastName(user.getLastName());
        target.setBlizzardAccount(user.getBlizzardAccount());
        target.setSocialMedia(user.getSocialMedia());

        // This should be in admin only
        // target.setUserRole(user.getUserRole());

        // This should be admin only
        // target.setActive(user.isActive());

        return (repository.save(target) != null) ? true : false;
    }

    @Override
    public boolean remove(String id) {
        UUID idAsUUID = UUID.fromString(id);

        try {
            repository.delete(idAsUUID);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // @Override
    // public User login(String username, String password) {
    // return repository.login(username, password);
    // }
}
