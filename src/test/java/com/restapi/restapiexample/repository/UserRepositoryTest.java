package com.restapi.restapiexample.repository;

import com.restapi.restapiexample.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    User user;

    @BeforeEach
    void setUp() {
        user = new User("1", "Raj", "E-city", "8t8777867698");
        userRepository.save(user);
    }

    @AfterEach
    void tearDown() {
        user = null;
        userRepository.deleteAll();
    }
}
