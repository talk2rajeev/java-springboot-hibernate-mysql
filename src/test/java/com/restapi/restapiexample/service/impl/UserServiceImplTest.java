package com.restapi.restapiexample.service.impl;

import com.restapi.restapiexample.model.User;
import com.restapi.restapiexample.repository.UserRepository;
import com.restapi.restapiexample.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.configuration.IMockitoConfiguration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


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
        mock(User.class);
        mock(UserRepository.class, Mockito.CALLS_REAL_METHODS);
        doAnswer(Answers.CALLS_REAL_METHODS).when(userRepository).deleteById(any());
        assertThat(userService.deleteUser("1")).isEqualTo("Success");
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
        mock(User.class);
        mock(UserRepository.class);

        when(userRepository.findAll()).thenReturn(new ArrayList<User>(Collections.singleton(user)));
        assertThat(userService.getUsers().get(0)).isEqualTo(user);
    }

    @Test
    void getByUserName() {
        mock(User.class);
        mock(UserRepository.class);

        when(userRepository.findByUserName("Raj")).thenReturn(
                new ArrayList<User>(Collections.singleton(user))
        );
        assertThat(userService.getByUserName("Raj").get(0)).isEqualTo(user);
        assertThat(userService.getByUserName("Raj").get(0).getUserId()).isEqualTo(user.getUserId() );

    }
}