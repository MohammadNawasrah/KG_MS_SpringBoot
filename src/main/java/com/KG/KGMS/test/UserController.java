package com.KG.KGMS.test;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private List<User> users = new ArrayList<>();

    public UserController() {
        // Add sample user data to the array
        users.add(new User("user1@example.com", "password1"));
        users.add(new User("user2@example.com", "password2"));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        // Validate the user credentials
        if (validateUser(user)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    private boolean validateUser(User user) {
        for (User u : users) {
            if (u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
}