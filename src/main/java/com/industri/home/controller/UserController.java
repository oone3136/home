package com.industri.home.controller;

import com.industri.home.model.User;
import com.industri.home.security.service.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServices services;

    @GetMapping("/users")
    public List<User> findAll() {
        return services.findAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable("id") String id) {
        return services.findById(id);
    }

    @PostMapping("/users")
    public User create(@RequestBody User users) {
        return services.create(users);
    }

    @PutMapping("/users/{id}")
    public User edit(@PathVariable("id") String id, @RequestBody User users) {

        return services.edit(users, id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable("id") String id) {
        services.deleteById(id);
    }

}
