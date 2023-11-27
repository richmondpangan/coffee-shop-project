/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.coffeeshop.controller;

import com.project.coffeeshop.model.User;
import com.project.coffeeshop.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/api/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
