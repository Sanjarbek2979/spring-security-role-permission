package com.example.springsecurityrolepermission.component;

import com.example.springsecurityrolepermission.entity.Company;
import com.example.springsecurityrolepermission.entity.Role;
import com.example.springsecurityrolepermission.entity.User;
import com.example.springsecurityrolepermission.entity.enums.PermissionEnum;
import com.example.springsecurityrolepermission.entity.enums.RoleEnum;
import com.example.springsecurityrolepermission.repository.CompanyRepository;
import com.example.springsecurityrolepermission.repository.RoleRepository;
import com.example.springsecurityrolepermission.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Sanjarbek Allayev, пт 9:29. 04.03.2022
 */
@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {
@Value("${spring.sql.init.mode}")
private String mode;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;



   final RoleRepository roleRepository;
   final UserRepository userRepository;
   final CompanyRepository companyRepository;
   final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
        if (mode.equals("always") && ddl.equals("create")){
            Role admin= new Role();
            admin.setName(RoleEnum.ADMIN);
            admin.setPermissionEnumSet(Arrays.stream(PermissionEnum.values()).collect(Collectors.toSet()));
            Role manager= new Role();
            manager.setName(RoleEnum.MANAGER);
            manager.setPermissionEnumSet(new HashSet<>(Arrays.asList(
                    PermissionEnum.READ_ALL_EMPLOYEE,
                    PermissionEnum.EDIT_EMPLOYEE,
                    PermissionEnum.READ_EMPLOYEE
            )));
            Role user_role= new Role();
            user_role.setName(RoleEnum.USER);
            user_role.setPermissionEnumSet(new HashSet<>(Arrays.asList(
                    PermissionEnum.READ_ALL_EMPLOYEE,
                    PermissionEnum.READ_EMPLOYEE
            )));
            roleRepository.save(admin);
            roleRepository.save(user_role);
            roleRepository.save(manager);

            Company company = new Company();
            company.setName("PDP");
            companyRepository.save(company);


            Set<Role> roles= new HashSet<>();
            roles.add(admin);
            roles.add(user_role);
            roles.add(manager);
            User user= new User("Sanjar",roles,"admin",passwordEncoder.encode("123"),true);
            userRepository.save(user);

        }
    }
}
