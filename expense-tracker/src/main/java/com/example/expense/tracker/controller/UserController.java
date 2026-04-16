package com.example.expense.tracker.controller;

import com.example.expense.tracker.entity.User;
import com.example.expense.tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService usersevice;
    @PostMapping
    public User createUser(@RequestBody User user){
        return usersevice.save(user);
    }
    @GetMapping
    public List<User>getAllUsers(){
       return usersevice.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return usersevice.getUserById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        usersevice.deleteUserById(id);
    }




}
