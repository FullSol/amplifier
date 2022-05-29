package com.amplifier.services;

import java.util.List;

import com.amplifier.models.UserCharacter;
import com.amplifier.repositories.UserCharacterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserCharacterServiceImpl implements UserCharacterService {

    @Autowired
    private UserCharacterRepository repository;

    @Override
    public boolean add(UserCharacter character) {
        int pk = repository.save(character).getId();
        return (pk > 0) ? true : false;
    };

    @Override
    public UserCharacter getById(int id) {
        return repository.findById(id);
    };

    @Override
    public List<UserCharacter> getAll() {
        return repository.findAll();
    };

    @Override
    public boolean edit(UserCharacter character) {
        UserCharacter target = repository.findById(character.getId());

        target.setId(character.getId());
        target.setName(character.getName());
        target.set_class(character.get_class());
        target.setGender(character.getGender());
        target.setLevel(character.getLevel());
        target.setKillsElites(character.getKillsElites());
        target.setParagonLevel(character.getParagonLevel());
        target.setHardcore(character.isHardcore());
        target.setSeasonal(character.isSeasonal());
        target.setDead(character.isDead());

        return (repository.save(target) != null) ? true : false;
    };

    @Override
    public boolean remove(int id) {
        return repository.delete(id);
    }

}
