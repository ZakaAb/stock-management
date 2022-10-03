package com.example1.controller;


import com.example1.model.User;
import com.example1.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

}
