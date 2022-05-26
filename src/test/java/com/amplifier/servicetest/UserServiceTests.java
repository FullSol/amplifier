package com.amplifier.servicetest;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.amplifier.repositories.UserRepositoryImpl;
import com.amplifier.models.User;
import com.amplifier.services.UserService;
import com.amplifier.services.UserServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class UserServiceTests extends TestCase {
	
	private UserRepositoryImpl mockdao;
	private UserService userv;

	List<User> dummyDb;
	
	@Before
	public void setUp() {
		
		
		mockdao = Mockito.mock(UserRepositoryImpl.class);
				
		userv = new UserServiceImpl(mockdao);
		
		User u1 = new User(1, "John", "Smith", "jsmith01@gmail.com", "jayjay", 7);
		User u2 = new User(2, "Jane", "Doe", "jdoe77@gmail.com", "jayday", 33);
		// User u3 = new User(3, "Gerard", "Departew", "gtgotit89@gmail.com", "gerger", 14);
		User u4 = new User(4, "Jane", "Dreezy", "jdreezy77@gmail.com", "jordan", 47);
		
		List<User> dummyDb = new ArrayList<User>();
		dummyDb.add(u1);
		dummyDb.add(u2);
		// dummyDb.add(u3);
		dummyDb.add(u4);
	
	}

	@Test
	public void testLogin_Success() throws NullPointerException{
		
		User testUser = new User(3, "Gerard", "Departew", "gtgotit89@gmail.com", "gerger", 14);
		User testUser2 = new User(4, "Garth", "Deeper", "gogogadget88@gmail.com", "gasbag", 11);
		List<User> testDb = new ArrayList<>();
		testDb.add(testUser);
		testDb.add(testUser2);

		when(mockdao.findAll()).thenReturn(testDb);


		assertNotNull(userv.login("gtgotit89@gmail.com", "gerger"));	


	}


	@Test
	public void testRegister_returnUser(){
		User u5 = new User(5, "test", "test", "test", "test", 47);

		when(mockdao.create(u5)).thenReturn(true);

		assertEquals(u5, userv.getUserById(5));
	}

	@Test
	public void testRegisterNullUser_returnsNullUser(){
		User u5 = new User(5, "", "", "", "", 0);

		when(mockdao.create(u5)).thenReturn(false);
		assertNull( userv.getUserById(5));
	}

	@Test
	public void test_getAllUsers(){
		
		when(mockdao.findAll()).thenReturn(dummyDb);

		List<User> userList = userv.getAllUsers();

		assertEquals(dummyDb, userList);

	}




	@Test
	public void test_locateUserById(){
		

		User testUser = new User(3, "Gerard", "Departew", "gtgotit89@gmail.com", "gerger", 14);
		User testUser2 = new User(4, "Garth", "Deeper", "gogogadget88@gmail.com", "gasbag", 11);
		List<User> testDb = new ArrayList<>();
		testDb.add(testUser);
		testDb.add(testUser2);

		when(mockdao.findAll()).thenReturn(testDb);

		assertEquals(testUser, userv.getUserById(3));

	}


	@Test
	public void test_updateUser_GetByFirstNameNotSamereturn(){
		
		User testUser = new User(3, "Gerard", "Departew", "gtgotit89@gmail.com", "gerger", 14);
		User testUser2 = new User(4, "Garth", "Deeper", "gogogadget88@gmail.com", "gasbag", 11);
		List<User> testDb = new ArrayList<>();
		testDb.add(testUser);
		testDb.add(testUser2);

		when(mockdao.findAll()).thenReturn(testDb);


		testUser.setFirstName("Greg");

		userv.updateUser(testUser);



		assertNotSame("Gerard", testUser.getFirstName());


	}



	@Test
	public void test_deleteUserByIDsuccessReturnNull(){

		when(mockdao.findAll()).thenReturn(dummyDb);

		userv.deleteUserById(2);

		assertNull(userv.getUserById(2));

	}

 
}
