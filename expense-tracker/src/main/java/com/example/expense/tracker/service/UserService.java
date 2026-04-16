package com.example.expense.tracker.service;

import com.example.expense.tracker.entity.User;
import com.example.expense.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User save(User user){
        return  userRepository.save(user);
    }
    public List<User>getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() ->new RuntimeException("User not found"));
    }
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }


}
