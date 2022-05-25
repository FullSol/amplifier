package com.amplifier.services;

import java.util.List;

import com.amplifier.models.UserCharacter;
import com.amplifier.repositories.CharacterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserCharacterServiceImpl implements UserCharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public boolean create(UserCharacter character) {
        int pk = characterRepository.save(character).getId();
        return (pk > 0) ? true : false;
    };

    @Override
    public UserCharacter getById(int id) {
        return characterRepository.findById(id);
    };

    @Override
    public List<UserCharacter> getAll() {
        return characterRepository.findAll();
    };

    @Override
    public boolean update(UserCharacter character) {
        UserCharacter target = characterRepository.findById(character.getId());
        target.setName(character.getName());
        target.setRealm(character.getRealm());
        return (characterRepository.save(target) != null) ? true : false;
    };

    @Override
    public boolean delete(int id) {
        return characterRepository.deleteById(id);
    }

}
