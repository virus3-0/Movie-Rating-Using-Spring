package com.example.MovieRating.service;

import com.example.MovieRating.Security.CustomUserDetails;
import com.example.MovieRating.model.User;
import com.example.MovieRating.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepositoryObject;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userObject = userRepositoryObject.findByUsername(s);
        if (userObject==null){
            throw new UsernameNotFoundException("User not Found");
        }
        return new CustomUserDetails(userObject);
    }
}
