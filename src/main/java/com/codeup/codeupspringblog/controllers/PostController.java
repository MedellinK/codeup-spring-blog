package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.CommentRepository;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PostController {

    private PostRepository postDao;

    private UserRepository userDao;
    private CommentRepository commentDao;

    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, CommentRepository commentDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.commentDao = commentDao;
        this.emailService = emailService;

    }


@GetMapping("/posts")
    public String allPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        postDao.findAll();
        return "/posts/index";
    }

    @GetMapping("/api/posts")
    public @ResponseBody List<Post> getAllPostsButApiStyle() {
        return postDao.findAll();
    }

    @GetMapping("/posts/{id}")
    public String individualPost() {

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }
//    @PostMapping("/posts/create")
//    public String createPost(@RequestParam (name = "title") String title, @RequestParam (name = "body") String body) {
//        User user = userDao.findById(1L);
//        Post post = new Post(user, body, title);
//
//        postDao.save(post);
//        return "redirect:/posts";
//    }
    @PostMapping("/posts/create")
    public String submitForm(@ModelAttribute Post post) {
        User user = userDao.findById(1L);
        post.setUser(user);
        postDao.save(post);
        emailService.sendEmail(user.getEmail(), "Post created", "You created a post with the id of " + post.getId());
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
//        Post post = postDao.findById(id);
        model.addAttribute("post", new Post());
        return "posts/edit";
    }

//    @PostMapping("/posts/comment")
//    public String submitComment(@RequestParam (name = "content") String content, @RequestParam (name = "post_id") Long post_id) {
//        Post post = postDao.findById(post_id);
//        Comment content = new Comment(content, post);
//        commentDao.save(content);
//        return "redirect:/posts";
//    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, @ModelAttribute Post post) {
        User user = userDao.findById(1L);
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }



}
