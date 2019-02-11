package com.estheto.esms.services;

import com.estheto.esms.models.User;
import com.estheto.esms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
        return "User with username " + user.getUsername() + "is created.";
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getByUserName(String userName) {
        return repo.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException("No user with "
                + "the name " + userName + "was found in the database"));
    }
}
