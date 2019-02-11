package com.estheto.esms.controller;

import com.estheto.esms.models.User;
import com.estheto.esms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping(value = "/{userName}")
    public User getByUserName(@PathVariable("userName") String userName){
        return service.getByUserName(userName);
    }

    @PostMapping(value = "addUser")
    public String addUser(@RequestBody User user) {
        return service.save(user);
    }

}
