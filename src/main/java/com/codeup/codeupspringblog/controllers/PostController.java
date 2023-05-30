package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }
@GetMapping("/posts")
    public String allPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        postDao.findAll();
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost() {

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createForm() {
    return "posts/create";
    }
    @PostMapping("/posts/create")
    public String createPost(@RequestParam (name = "title") String title, @RequestParam (name = "body") String body) {
        Post post = new Post(title, body);
        System.out.println(post.getTitle());
        System.out.println(post.getBody());
        postDao.save(post);
        return "redirect:/posts";
    }


}
