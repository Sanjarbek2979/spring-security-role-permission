package com.example.springsecurityrolepermission.controller;

import com.example.springsecurityrolepermission.dto.LoginDTO;
import com.example.springsecurityrolepermission.dto.RegisterDTO;
import com.example.springsecurityrolepermission.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sanjarbek Allayev, пт 8:59. 04.03.2022
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    AuthService authService;


    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDTO dto){
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUserName(), dto.getPassword()));
        System.out.println(authenticate);
        System.out.println();
        return ResponseEntity.ok().body("Tizimga xush kelibsiz!");

    }
    @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody RegisterDTO dto){
        String register = authService.register(dto);
        return ResponseEntity.ok().body(register);

    }
}
