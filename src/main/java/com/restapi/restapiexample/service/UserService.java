package com.restapi.restapiexample.service;

import com.restapi.restapiexample.model.User;

import java.util.List;

public interface UserService {
    public String createUser(User user);
    public String updateUser(User user);
    public String deleteUser(String userId);
    public User getUser(String userId);
    public List<User> getUsers();

    public List<User> getByUserName(String userName);
}
