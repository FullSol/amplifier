package com.amplifier.services;

import java.util.List;

import com.amplifier.models.UserCharacter;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface CharacterService {
    public boolean create(UserCharacter character);

    public UserCharacter getById(int id);

    public List<UserCharacter> getAll();

    public boolean update(UserCharacter character);

    public boolean delete(int id);
}
