/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.coffeeshop.service;

import com.project.coffeeshop.exception.UserNotFoundException;
import com.project.coffeeshop.model.User;
import com.project.coffeeshop.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
    
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).get();
    }
    
    public void registerUser(User user) {
        userRepository.save(user);
    }
    
    public void updateUser(Integer userId, User user) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUserFirstName(user.getUserFirstName());
            existingUser.setUserLastName(user.getUserLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setRole(user.getRole());
            
            userRepository.save(existingUser);
        }
        else {
            throw new UserNotFoundException("User with ID " + userId + " not found");
        }
    }
    
    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }
    
    //Login
}
