package com.amplifier.repositories;

import java.util.List;

public interface CharacterRepository {

    Character save(Character character);

    Character findById(int id);

    List<Character> findAll();

    boolean deleteById(int id);

}
