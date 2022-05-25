package com.amplifier.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface CharacterService {
    public boolean create(Character character);

    public Character getById(int id);

    public List<Character> getAll();

    public boolean update(Character character);

    public boolean delete(int id);
}
