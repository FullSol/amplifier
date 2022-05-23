package com.amplifier.services;

import java.util.List;

import com.amplifier.models.ImgPost;
import com.amplifier.repositories.ImgPostRepositoryImpl;

import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ImgPostServiceTest {

    private ImgPostServiceImpl imgPostService;
    private ImgPostRepositoryImpl mockrepo;
    private ImgPost imgPost1, imgPost2;
    List<ImgPost> dummyDb;

    @Before
    public void setup() {

    }
}
