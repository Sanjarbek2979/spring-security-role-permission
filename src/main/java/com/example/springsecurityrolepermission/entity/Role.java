package com.example.springsecurityrolepermission.entity;

import com.example.springsecurityrolepermission.entity.enums.PermissionEnum;
import com.example.springsecurityrolepermission.entity.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Sanjarbek Allayev, пт 8:58. 04.03.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<PermissionEnum> permissionEnumSet;

}
