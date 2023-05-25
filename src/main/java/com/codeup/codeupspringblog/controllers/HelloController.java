package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    //This is without a path variable
    //This method prints out the string in the url path in the browser window
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from spring!";
    }

    //This is with one path variable
    //This method prints out the name in the url path in the browser window
    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    //This is with two path variables
    //This method prints out the name in the url path in the browser window

    @RequestMapping(path = "/hello/{name1}/and/{name2}", method= RequestMethod.POST)
    @ResponseBody
    public String sayHelloTwo(@PathVariable String name1, @PathVariable String name2) {
        return name1 + " says hello to " + name2 + "!";
    }

//    @GetMapping()

}
