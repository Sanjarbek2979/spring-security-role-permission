package com.example.springsecurityrolepermission.repository;

import com.example.springsecurityrolepermission.entity.Role;
import com.example.springsecurityrolepermission.entity.User;
import com.example.springsecurityrolepermission.entity.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Sanjarbek Allayev, пт 9:25. 04.03.2022
 */
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(RoleEnum name);
}
