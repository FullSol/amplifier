package com.amplifier.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.ImgPost;
import com.amplifier.models.User;
import com.amplifier.repositories.ImgPostRepositoryImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

@ExtendWith(MockitoExtension.class)
public class ImgPostServiceImplIntTest {

    @TestConfiguration
    static class ImgPostServiceImplTestConfiguration {
        @Bean
        public ImgPostServiceImpl imgPostService() {
            return new ImgPostServiceImpl();
        }
    }

    private static User mockUser1;
    private static User mockUser2;
    private static User mockUser3;
    private static ImgPost mockImgPost1;
    private static ImgPost mockImgPost2;
    private static ImgPost mockImgPostCreation;
    private static ImgPost mockImgPostModification;

    private static List<ImgPost> dummyDb;

    @Autowired
    private ImgPostServiceImpl imgPostService;

    @MockBean
    private ImgPostRepositoryImpl imgPostRepository;

    @BeforeAll
    public void setup() {
        mockUser1 = new User("FullSol", "fullsol@gmail.com", "password", "Calvin", "Raines", LocalDate.now());
        mockUser2 = new User("L3viathon", "L3viathon@gmail.com", "password", "Levi", "Choi", LocalDate.now());
        mockUser3 = new User("pyaeger", "pyaeger@gmail.com", "password", "Partrick", "Yaeger", LocalDate.now());
        mockImgPost1 = new ImgPost("http://localhost:8080", mockUser1);
        mockImgPost2 = new ImgPost("http://localhost:8081", mockUser2);

        mockImgPostCreation = new ImgPost("http://localhost:8082", mockUser3);

        mockImgPostModification = mockImgPostCreation;

        mockImgPostModification.setImgLocation("http://localhost:5432");
        mockImgPostModification.setAuthor(mockUser3);

        dummyDb = new ArrayList<>();
        dummyDb.add(mockImgPost1);
        dummyDb.add(mockImgPost2);
    }

    @Test
    @Order(1)
    @DisplayName("1. AppContext")
    public void contextLoads() {
        assertThat(imgPostService).isNotNull();
    }

    @Test
    @Order(1)
    @DisplayName("1. Get all img posts")
    public void getImgPosts_ShouldReturnImgPosts() throws Exception {

        //
        when(imgPostRepository.findAll());
    }
}