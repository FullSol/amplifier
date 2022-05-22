package com.amplifier.services;

import java.util.List;

public interface CharacterService {

  public boolean createCharacter(Character c);
  public boolean editCharacter(Character c);
  public List<Character> findAllCharacters();
  public Character findCharacterById(int id);
  public boolean deleteCharacter(Character c);

}
