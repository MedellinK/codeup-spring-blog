package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserRepository userDao;

    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/register")
    public String registration() {
        return "/register";
    }
    public String registerUser(@RequestParam (name="username") String username, @RequestParam (name = "email")String email, @RequestParam (name = "password")String password) {
        User user = new User(username, email, password);
        userDao.save(user);
        return "redirect:/ads";
    }
}
