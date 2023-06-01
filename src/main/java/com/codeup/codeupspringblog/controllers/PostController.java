package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Comment;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.CommentRepository;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    private PostRepository postDao;

    private UserRepository userDao;
    private CommentRepository commentDao;

    public PostController(PostRepository postDao, UserRepository userDao, CommentRepository commentDao) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.commentDao = commentDao;

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
        User user = userDao.getOne(1L);
        Post post = new Post(user, body, title);
        postDao.save(post);
        return "redirect:/posts";
    }

//    @PostMapping("/posts/comment")
//    public String submitComment(@RequestParam (name = "content") String content, @RequestParam (name = "post_id") Long post_id) {
//        Post post = postDao.findById(post_id);
//        Comment content = new Comment(content, post);
//        commentDao.save(content);
//        return "redirect:/posts";
//    }



}
