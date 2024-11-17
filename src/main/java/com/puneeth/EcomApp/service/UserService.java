package com.puneeth.EcomApp.service;

import com.puneeth.EcomApp.model.User;
import com.puneeth.EcomApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private JWTService jwtService;


    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User register(User user) {
        System.out.println(user);
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String verify(User user) {
        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            System.out.println("Here in user service");
            return jwtService.generateToken(user.getUsername())  ;
        } else {
            return "fail";
        }
    }
}
