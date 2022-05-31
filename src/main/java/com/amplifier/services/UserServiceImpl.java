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

    @Override
    public User login(User user) throws InvalidKeyException, JsonProcessingException {
        Optional<User> users = repository.findAll()
                .stream()
                .filter(u -> (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())))
                .findFirst();

        // return (users.isPresent() ? users.get() : null);
        if (users.isPresent() == false) {
            // Update to return 403
            return null;
        }

        String jwt = jwtService.createJwt(users.get());
        return null;
    }
}