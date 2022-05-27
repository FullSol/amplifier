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
    private CharacterRepository repository;

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
        target.setName(character.getName());
        target.setRealm(character.getRealm());
        return (repository.save(target) != null) ? true : false;
    };

    @Override
    public boolean remove(int id) {
        return repository.delete(id);
    }

}
