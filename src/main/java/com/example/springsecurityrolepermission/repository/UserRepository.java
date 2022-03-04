package com.example.springsecurityrolepermission.repository;

import com.example.springsecurityrolepermission.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Sanjarbek Allayev, пт 9:25. 04.03.2022
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUserName(String userName);
}
