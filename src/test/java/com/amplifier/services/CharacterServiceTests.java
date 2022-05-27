package com.amplifier.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.amplifier.repositories.CharacterRepository;
import com.amplifier.repositories.CharacterRepositoryImpl;
import com.amplifier.models.Character;
import com.amplifier.services.CharacterService;
import com.amplifier.services.CharacterServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class CharacterServiceTests extends TestCase {

	private CharacterRepository mockdao;
	private CharacterService cserv;

	List<Character> dummyDb;

	@Before
	public void setUp() {

		mockdao = Mockito.mock(CharacterRepositoryImpl.class);

		cserv = new CharacterServiceImpl();

		Character c1 = new Character(1, "regret", "karfage");
		Character c2 = new Character(2, "discord", "multiplus");
		Character c3 = new Character(3, "terror", "frindle");

		List<Character> dummyDb = new ArrayList<Character>();
		dummyDb.add(c1);
		dummyDb.add(c2);
		dummyDb.add(c3);

	}

	@Test
	public void test_getAllCharacters() {

		when(mockdao.getAll()).thenReturn(dummyDb);

		List<Character> charList = cserv.getAllCharacters();

		assertEquals(dummyDb, charList);

	}

	@Test
	public void test_getAllCharactersByRealm() {

		Character c1 = new Character(1, "regret", "karfage");
		Character c2 = new Character(2, "discord", "multiplus");
		Character c3 = new Character(3, "regret", "frindle");

		List<Character> dummyDb = new ArrayList<Character>();
		dummyDb.add(c1);
		dummyDb.add(c2);
		dummyDb.add(c3);

		when(mockdao.getAll()).thenReturn(dummyDb);

		List<Character> charList = cserv.getAllCharactersByRealm("regret");

		assertEquals(2, charList.size());

	}

	@Test
	public void test_locateUserById() {

		/**
		 * currently returning null because of no implemetation in repo/servic layer
		 */

		Character c1 = new Character(1, "regret", "karfage");
		Character c2 = new Character(2, "discord", "multiplus");
		Character c3 = new Character(3, "terror", "frindle");

		List<Character> dummyDb = new ArrayList<Character>();
		dummyDb.add(c1);
		dummyDb.add(c2);
		dummyDb.add(c3);

		when(mockdao.getAll()).thenReturn(dummyDb);

		assertEquals(c3, cserv.getCharacterById(3));

	}

	@Test
	public void testRegister_returnUser() {
		Character c5 = new Character(5, "test", "test");

		when(mockdao.create(c5)).thenReturn(true);

		assertEquals(c5, cserv.getCharacterById(5));
	}

	@Test
	public void testRegisterNullUser_returnsNullUser() {
		Character c5 = new Character(5, "", "");

		when(mockdao.create(c5)).thenReturn(false);
		assertNull(cserv.getCharacterById(5));
	}

	@Test
	public void test_updateUser_GetByFirstNameNotSamereturn() {

		Character c1 = new Character(1, "regret", "karfage");
		Character c2 = new Character(2, "discord", "multiplus");
		Character c3 = new Character(3, "terror", "frindle");

		List<Character> dummyDb = new ArrayList<Character>();
		dummyDb.add(c1);
		dummyDb.add(c2);
		dummyDb.add(c3);

		when(mockdao.getAll()).thenReturn(dummyDb);

		c1.setCharacter_name("Greg");

		cserv.updateCharacter(c1);

		assertNotSame(c1, cserv.getCharacterByName("karfage"));

	}

	@Test
	public void test_updateUser_GetByFirstNameSamereturn() {

		Character c1 = new Character(1, "regret", "karfage");
		Character c2 = new Character(2, "discord", "multiplus");
		Character c3 = new Character(3, "terror", "frindle");

		List<Character> dummyDb = new ArrayList<Character>();
		dummyDb.add(c1);
		dummyDb.add(c2);
		dummyDb.add(c3);

		when(mockdao.getAll()).thenReturn(dummyDb);

		c1.setCharacter_name("Greg");

		cserv.updateCharacter(c1);

		assertSame(c1, cserv.getCharacterByName("Greg"));

	}

	@Test
	public void test_deleteUserByIDsuccessReturnNull() {

		when(mockdao.getAll()).thenReturn(dummyDb);

		cserv.deleteCharacterById(2);

		assertNull(cserv.getCharacterById(2));

	}

}