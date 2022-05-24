package com.amplifier.repositories;

import java.util.List;

public interface CharacterRepository {

    public List<Character> findAll();

    public boolean create(Character character);

    public Character findById(int id);

    public boolean update(Character character);

    public boolean deleteById(int id);

}
