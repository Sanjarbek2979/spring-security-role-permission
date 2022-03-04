package com.example.springsecurityrolepermission.service;

import com.example.springsecurityrolepermission.dto.RegisterDTO;
import com.example.springsecurityrolepermission.entity.Role;
import com.example.springsecurityrolepermission.entity.User;
import com.example.springsecurityrolepermission.entity.enums.RoleEnum;
import com.example.springsecurityrolepermission.repository.RoleRepository;
import com.example.springsecurityrolepermission.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

/**
 * @author Sanjarbek Allayev, пт 9:59. 04.03.2022
 */
@Service
@RequiredArgsConstructor

public class AuthService implements UserDetailsService {
    final UserRepository userRepository;
    final RoleRepository roleRepository;
    final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication=context.getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        System.out.println(authorities);

        System.out.println(authentication.getCredentials());
        System.out.println(authentication.getPrincipal());
        System.out.println(authentication.getDetails());

        return userRepository.findByUserName(username).orElseThrow( ()-> new UsernameNotFoundException(username));
    }
    public String  register(RegisterDTO dto){
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setFullName(dto.getFullName());
        Optional<Role> byName = roleRepository.findByName(RoleEnum.USER);
        user.setRoles(new HashSet<>(Arrays.asList(byName.get())));
        userRepository.save(user);
        return "Registered";
    }
}
