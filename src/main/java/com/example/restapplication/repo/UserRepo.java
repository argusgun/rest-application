package com.example.restapplication.repo;

import com.example.restapplication.entetities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByName(String name);
}
