package com.restapi.restapiexample.service.impl;

import com.restapi.restapiexample.exception.UserNotFoundException;
import com.restapi.restapiexample.model.User;
import com.restapi.restapiexample.repository.UserRepository;
import com.restapi.restapiexample.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* Business Logic For UserInfo
* */

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public String createUser(User user) {
        userRepository.save(user);
        return "Success";
    }

    @Override
    public String updateUser(User user) {
        userRepository.save(user);
        return "Success";
    }

    @Override
    public String deleteUser(String userId) {
        userRepository.deleteById(userId);
        return "Success";
    }

    @Override
    public User getUser(String userId) {
        if(userRepository.findById(userId).isEmpty())
            throw new UserNotFoundException("Requested User not found!");
        return userRepository.findById(userId).get();
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getByUserName(String userName)
    {
        return userRepository.findByUserName(userName);
    }
}
