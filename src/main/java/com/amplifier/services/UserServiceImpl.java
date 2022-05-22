package com.amplifier.services;

import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.User;
import com.amplifier.repositories.UserRepositoryImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepositoryImpl userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
