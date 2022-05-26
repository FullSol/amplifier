package com.amplifier.services;

import java.util.List;

import com.amplifier.models.Character;

public interface CharacterService {

    public boolean createCharacter(Character character);

    public Character getCharacterById(int id);

    public List<Character> getAllCharacters();

    public List<Character> getAllCharactersByRealm(String character_realm);

    public Character getCharacterByName(String character_name);

    public boolean updateCharacter(Character character);

    public boolean deleteCharacterById(int id);



}
