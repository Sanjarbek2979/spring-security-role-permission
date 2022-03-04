package com.example.springsecurityrolepermission.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sanjarbek Allayev, пт 11:49. 04.03.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterDTO {
private String fullName;
private String userName;
private String password;
private String prePassword;
}
