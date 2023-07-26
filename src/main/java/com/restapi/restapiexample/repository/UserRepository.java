package com.restapi.restapiexample.repository;

import com.restapi.restapiexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByUserName(String userName);
}
