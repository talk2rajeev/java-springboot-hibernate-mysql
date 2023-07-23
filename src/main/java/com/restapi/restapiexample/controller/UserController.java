package com.restapi.restapiexample.controller;

import com.restapi.restapiexample.model.User;
import com.restapi.restapiexample.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{userId}")
    public User getUserDetail(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }

    @GetMapping()
    public List<User> getAllUsersDetail() {
        return userService.getUsers();
    }

    @PostMapping
    public String createUserDetail(@RequestBody User user) {
        userService.createUser(user);
        return "User created Successfully";
    }

    @PutMapping
    public String updateUserDetail(@RequestBody User user) {
        userService.updateUser(user);
        return "User updated Successfully";
    }

    @DeleteMapping("{userId}")
    public String deleteUserDetail(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return "User deleted Successfully";
    }
}

