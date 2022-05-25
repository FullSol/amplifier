package com.amplifier.services;

import java.util.List;

import com.amplifier.repositories.CharacterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public boolean create(Character character) {
        int pk = characterRepository.save(character).getId();
        return (pk > 0) ? true : false;
    };

    public Character findById(int id) {
        return characterRepository.findById(id);
    };

    public List<Character> findAll() {
        return characterRepository.findAll();
    };

    public boolean update(Character character) {
        Character target = characterRepository.findById(character.getId());
        target.setName(character.getName());
        target.setRealm(character.getRealm());
        return (characterRepository.save(target) != null) ? true : false;
    };

    public boolean delete(int id) {
        return characterRepository.deleteById(id);
    };
}
