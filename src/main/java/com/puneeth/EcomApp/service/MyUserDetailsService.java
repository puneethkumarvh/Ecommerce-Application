package com.puneeth.EcomApp.service;

import com.puneeth.EcomApp.model.User;
import com.puneeth.EcomApp.model.UserPrincipal;
import com.puneeth.EcomApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepo.findByUserName(username);
        if(user==null){
            System.out.println("User not found.");
            throw new UsernameNotFoundException("User not found.");
        }
        return new UserPrincipal(user);
    }
}
