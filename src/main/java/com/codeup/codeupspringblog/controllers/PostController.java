package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PostController {

@GetMapping("/posts")
    @ResponseBody
    public String allPosts() {
        return "This is the posts index page!";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost() {
        return "This is the individual post page!";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createForm() {
        return "This is the create post page!";
    }

    @RequestMapping(path = "/posts/create", method= RequestMethod.POST)
    @ResponseBody
    public String submitFrom() {
        return "This is the create post page!";
    }
}
