package com.example.springsecurityrolepermission.entity;

import com.example.springsecurityrolepermission.entity.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author Sanjarbek Allayev, пт 8:58. 04.03.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Company {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;

    @OneToMany
    List<User> users;

}
