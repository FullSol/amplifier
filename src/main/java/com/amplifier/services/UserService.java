package com.amplifier.services;

import java.util.List;
import java.util.UUID;

import com.amplifier.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.jsonwebtoken.security.InvalidKeyException;

@Service
@Transactional
public interface UserService {
    public List<User> getAll();

    public boolean add(User user);

    public User getById(String id);

    public boolean edit(User user);

    public boolean remove(String id);

    public User login(User user) throws InvalidKeyException, JsonProcessingException;

}
