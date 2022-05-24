package com.amplifier.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CharacterRepositoryImpl implements CharacterRepository {

    @Autowired
    private Character character;


    @Override
    public List<Character> findAll() {
        return null;
    }

    @Override
    public boolean create(Character character) {
        return false;
    }

    @Override
    public Character findById(int id) {
        return null;
    }

    @Override
    public boolean update(Character character) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

}
