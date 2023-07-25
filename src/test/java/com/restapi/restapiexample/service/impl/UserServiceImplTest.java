package com.restapi.restapiexample.service.impl;

import com.restapi.restapiexample.model.User;
import com.restapi.restapiexample.repository.UserRepository;
import com.restapi.restapiexample.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.configuration.IMockitoConfiguration;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    private UserService userService;
    AutoCloseable autoCloseable;
    User user;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl(userRepository);
        user = new User("1", "Raj", "E-city", "8t8777867698");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateUser() {
        mock(User.class);
        mock(UserRepository.class);

        when(userRepository.save(user)).thenReturn(user);
        assertThat(userService.createUser(user)).isEqualTo("Success");
    }

    @Test
    void updateUser() {
        mock(User.class);
        mock(UserRepository.class);

        when(userRepository.save(user)).thenReturn(user);
        assertThat(userService.updateUser(user)).isEqualTo("Success");
    }

    @Test
    void deleteUser() {
    }

    @Test
    void getUser() {
        mock(User.class);
        mock(UserRepository.class);

        when(userRepository.findById("1")).thenReturn(Optional.ofNullable(user));
        assertThat(userService.getUser("1").getUserName()).isEqualTo(user.getUserName());
    }

    @Test
    void getUsers() {
    }
}