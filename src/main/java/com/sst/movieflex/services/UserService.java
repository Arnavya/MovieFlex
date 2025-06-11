package com.sst.movieflex.services;

import com.sst.movieflex.models.User;
import com.sst.movieflex.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(String name, String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            //User with the given email already present
            //Ask them to try to login
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        //user.setPassword(password);

        return userRepository.save(user);
    }
}
