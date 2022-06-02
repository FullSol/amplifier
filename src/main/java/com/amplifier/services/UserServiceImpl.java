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

    @Autowired
    private static JwtServiceImpl jwtService = new JwtServiceImpl();

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

    @Override
    public User login(User user) throws InvalidKeyException, JsonProcessingException {
        Optional<User> users = repository.findAll()
                .stream()
                .filter(u -> (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())))
                .findFirst();

        // return (users.isPresent() ? users.get() : null);
        if (users.isPresent()) {
            // Update to return 403
            return users.get();
        }

        return null;
    }
}