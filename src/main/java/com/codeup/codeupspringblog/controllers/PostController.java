package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PostController {

@GetMapping("/posts")
    public String allPosts() {
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost() {
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createForm() {
        return "This is the create post page!";
    }

    @RequestMapping(path = "/posts/create", method= RequestMethod.POST)
    @ResponseBody
    public String submitFrom() {
        return "This is the create post page!";
    }
}
