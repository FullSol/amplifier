package com.amplifier.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.amplifier.models.User;
import com.amplifier.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.jsonwebtoken.security.InvalidKeyException;

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
    public User getById(UUID id) {
        return repository.findById(id).get();
    }

    @Override
    public boolean edit(User user) {
        // Get the DB user version from the DB
        User target = repository.findById(user.getId()).get();

        /**
         * Compare the DB user version with the user version. If they are different,
         * update the DB user version with the user version.
         */

        target.setUsername(user.getUsername());

        target.setEmail(user.getEmail());

        target.setPassword(user.getPassword());

        target.setFirstName(user.getFirstName());

        target.setLastName(user.getLastName());

        target.setBattleTag(user.getBattleTag());

        target.setUserRole(user.getUserRole());

        target.setActive(user.isActive());

        return (repository.save(target) != null) ? true : false;
    }

    @Override
    public boolean remove(UUID id) {

        try {
            repository.delete(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public User login(User user) throws InvalidKeyException, JsonProcessingException {
        Optional<User> users = repository.findAll()
                .stream()
                .filter(u -> (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())))
                .findFirst();

        User target = users.get();

        if (target != null) {
            // TODO: Update to return 403
            return users.get();
        } else {
            throw new InvalidKeyException("Invalid user");
        }
    }

    @Override
    public User register(User user) {
        UUID pk = repository.save(user).getId();
        user.setId(pk);
        return user;
    }
}