package com.example.springsecurityrolepermission.repository;

import com.example.springsecurityrolepermission.entity.Company;
import com.example.springsecurityrolepermission.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sanjarbek Allayev, пт 9:25. 04.03.2022
 */
public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
