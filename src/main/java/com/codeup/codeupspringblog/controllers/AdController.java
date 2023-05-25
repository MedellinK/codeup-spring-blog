//package com.codeup.codeupspringblog.controllers;
//
//import models.Ad;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import repositories.AdRepository;
//
//@Controller
//public class AdController {
//
//    // dependency injection
//    private final AdRepository adDao;
//
//
//    public AdController(AdRepository adDao) {
//        this.adDao = adDao;
//    }
//
//    @GetMapping("/ads")
//    public String adIndex(Model model) {
//        model.addAttribute("ads", adDao.findAll());
//        adDao.findAll();
//        return "ads/index";
//    }
//
//@GetMapping("/ads/create")
//    public String createAdForm() {
//        return "ads/create";
//    }
//
//    @PostMapping("/ads/create")
//    public String createAd(@RequestParam (name = "title") String title, @RequestParam (name = "description") String description) {
//        Ad ad = new Ad();
//        ad.setTitle(title);
//        ad.setDescription(description);
//        adDao.save(ad);
//        return "redirect:/ads";
//    }
//}
