package com.restapi.restapiexample.repository;

import com.restapi.restapiexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
