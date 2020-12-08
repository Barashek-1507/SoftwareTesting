package com.example.test.controller;

import com.example.test.domain.Role;
import com.example.test.domain.User;
import com.example.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/registration")
    public String registration(Map<String, Object> model){
        return "/registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String , Object> model){
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if(userFromDB != null){
            model.put("message", "User exist!");
            return "registration";
        }

        if (user.getUsername().contains(" ") || user.getPassword().length() < 8){
            if (user.getUsername().contains(" ")){
                model.put("login", "Username mustn't contain space");
            }

            if (user.getUsername().length() < 8){
                model.put("password", "Password must have a length of more than 8 symbols");
            }
            return "registration";
        }


        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        model.put("added", "User has successfully been added");
        return "redirect:/login";
    }

}

