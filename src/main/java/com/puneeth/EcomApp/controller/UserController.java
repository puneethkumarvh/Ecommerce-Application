package com.puneeth.EcomApp.controller;

import com.puneeth.EcomApp.model.User;
import com.puneeth.EcomApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User register(@RequestBody User user){
        return userService.register(user);
    }

//    @PostMapping
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        // Save the user (the ID will be auto-generated)
//        User savedUser = userRepository.save(user);
//
//        // Return the saved user with the auto-generated ID
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
//    }
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.verify(user);
    }

    @GetMapping("/authorised_content")
    public String authorised_content(){
        return "Success sending for authorized content.";
    }

}
