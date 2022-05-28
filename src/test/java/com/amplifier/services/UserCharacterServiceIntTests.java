package com.amplifier.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.UserCharacter;
import com.amplifier.repositories.UserCharacterRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class UserCharacterServiceIntTests extends TestCase {

	@Mock
	private static UserCharacterRepository repository;

	@InjectMocks
	private static UserCharacterServiceImpl service;

	private static UserCharacter character1, character2, character3;
	private static List<UserCharacter> dummyDb;

	@Before
	public void setUp() {

		repository = Mockito.mock(UserCharacterRepository.class);

		service = new UserCharacterServiceImpl();

		character1 = new UserCharacter(1, "regret", "karfage");
		character2 = new UserCharacter(2, "discord", "multiplus");
		character3 = new UserCharacter(3, "terror", "frindle");

		List<UserCharacter> dummyDb = new ArrayList<UserCharacter>();
		dummyDb.add(character1);
		dummyDb.add(character2);
		dummyDb.add(character3);

	}

	@Test
	@Order(1)
	@DisplayName("1. Mock Validation Sanity Test")
	void checkMockInjection() {
		assertThat(repository).isNotNull();
		assertThat(service).isNotNull();
	}

	@Test
	@Order(2)
	@DisplayName("2. Get All User's Characters Test")
	public void test_getAllCharacters() {

		// Arranged in @Before

		// Behavior Setup
		when(repository.findAll()).thenReturn(dummyDb);

		// Action & Assert
		assertEquals(dummyDb, service.getAll());

	}

	@Test
	@Order(3)
	@DisplayName("3. Get All Character by ID")
	public void test_getAllCharactersById() {

		// Arranged in @Before

		// Behavior Setup
		when(repository.findById(1)).thenReturn(character1);

		// Action & Assert
		assertEquals(character1, service.getById(1));

	}

	@Test
	@Order(4)
	@DisplayName("4. Delete Character by ID")
	public void test_deleteUserByIDsuccessReturnNull() {

		// Arranged in @Before

		// Behavior Setup
		when(repository.findAll()).thenReturn(dummyDb);

		// Action
		service.remove(2);

		// Assert
		assertNull(service.getById(2));

	}

}