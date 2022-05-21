package com.revature.Amplifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

public class UserRestControllerIntegrationTest {
    @RunWith(SpringRunner.class)
    @SpringBootTest(
        SpringBootTest.WebEnvironment.MOCK,
        classes = Application.class)
    @AutoConfigureMockMvc
    @TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
    public class UserRestControllerIntegrationTest {

        @Autowired
        private MockMvc mvc;

        @Autowired
        private UserRepository repository;
    }
}
