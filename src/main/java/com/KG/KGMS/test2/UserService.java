package com.KG.KGMS.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public boolean validateUser(User requestUser, User user) {
        System.out.println(requestUser.getUsername());
        if (user != null)
            if (requestUser.getUsername().equals(user.getUsername())
                    && user.getPassword().equals(requestUser.getPassword())) {
                return true;
            }
        return false;
    }
    // Other methods for manipulating user data
    // ...
}
