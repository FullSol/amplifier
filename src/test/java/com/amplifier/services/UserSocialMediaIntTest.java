package com.amplifier.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.UserSocialMedia;
import com.amplifier.repositories.UserSocialMediaRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class UserSocialMediaIntTest {
    @Mock
    private static UserSocialMediaRepository repository;

    @InjectMocks
    private static UserSocialMediaServiceImpl service;

    private static UserSocialMedia social1, social2;
    static List<UserSocialMedia> dummyDb;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        /**
         * Mockito setup
         */
        // 1. Mock the depending classes
        repository = Mockito.mock(UserSocialMediaRepository.class);

        // 2. Inject service with mocked classes
        service = new UserSocialMediaServiceImpl(repository);

        /**
         * Dummy DB setup
         */
        social1 = new UserSocialMedia(1, "http://wwww.twitter.com/first", "http://wwww.facebook.com/first",
                "http://www.instagram.com/first");
        social2 = new UserSocialMedia(1, "http://wwww.twitter.com/second", "http://wwww.facebook.com/second",
                "http://www.instagram.com/second");

        dummyDb = new ArrayList<UserSocialMedia>();
        dummyDb.add(social1);
        dummyDb.add(social2);
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
    @DisplayName("2. Create Candy Happy Path Test")
    void testCreateCandy() {

        // Arrange
        UserSocialMedia social3 = new UserSocialMedia(1, "http://wwww.twitter.com/third",
                "http://wwww.facebook.com/third",
                "http://www.instagram.com/third");
        social3.setId(3);

        // Behavior Setup
        when(repository.save(social3)).thenReturn(social3);

        // Action & Assert
        assertEquals(true, service.add(social3));
    }

    @Test
    @Order(3)
    @DisplayName("3. Get Candy by Id Happy Path Test")
    void testGetCandyById() {
        // Arranged in @Before

        // Behavior Setup
        when(service.getById(1)).thenReturn(social1);

        // act + assert step
        assertEquals(social1, service.getById(1));
    }

    @Test
    @Order(4)
    @DisplayName("4. Get all Candies Happy Path Test")
    void testGetAllCandies() {
        // arrange step already done in setup
        // here we will tell mockito what type of behavior to expect from calling
        // certain methods from our dao
        when(service.getAll()).thenReturn(dummyDb);

        // act + assert step
        assertEquals(dummyDb, service.getAll());
    }

    @Test
    @Order(5)
    @DisplayName("5. Update Candy Happy Path Test")
    void testUpdateCandy() {
        social2.setTwitterLink("http://wwww.twitter.com/fourth");
        social2.setFacebookLink("http://wwww.facebook.com/fourth");

        when(service.getById(2)).thenReturn(social2);
        when(repository.save(social2)).thenReturn(social2);

        assertEquals(true, service.edit(social2));
    }

    @Test
    @Order(6)
    @DisplayName("6. Delete Candy Happy Path Test")
    void testDeleteCandy() {
        doNothing().when(mockdao).delete(c2);
        // act + assert step
        assertEquals(true, cserv.deleteCandy(c2));
    }

    @Test
    @Order(7)
    @DisplayName("7. Unneccessay/Unused Test")
    @Disabled("Disabled until CreateCandyTest is up!")
    // @Disabled will allow you to ignore this test while debugging other tests
    public void unusedTest() {
        return;
    }
}
