package com.example.springsecurityrolepermission.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sanjarbek Allayev, пт 10:41. 04.03.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDTO {
    private String userName;
    private String password;
}
