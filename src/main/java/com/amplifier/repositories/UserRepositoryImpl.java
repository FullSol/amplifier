package com.amplifier.repositories;

import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    @Query(value = "SELECT * FROM users", nativeQuery = true)
    public List<User> findAll() {
        return new ArrayList<>();
    }
}