package com.restapi.restapiexample.repository;

import com.restapi.restapiexample.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


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

    @Test
    void findByUserName_Found() {
        List<User> userList = userRepository.findByUserName("Raj");
        assertThat(userList.get(0).getUserId()).isEqualTo(user.getUserId());
        assertThat(userList.get(0).getUserAddress()).isEqualTo(user.getUserAddress());

    }

    @Test
    void findByUserName_NOTFound() {
        List<User> userList = userRepository.findByUserName("asdfsadf");
        assertThat(userList.isEmpty()).isEqualTo(true);
        assertThat(userList.isEmpty()).isTrue();
    }
}
