package com.amplifier.repositories;

import java.util.List;

import com.amplifier.models.Character;

public interface CharacterRepository {

    public List<Character> getAll();

    public Character getById(int id);

    public Character getByName(String name);

    public List<Character> getAllByRealm(String realm);

    public boolean create(Character character);

    public boolean update(Character character);

    public boolean delete(int id);

}
