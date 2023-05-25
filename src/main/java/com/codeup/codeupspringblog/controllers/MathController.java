package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    //This controller should listen for requests for several routes that correspond to basic arithmetic operations and produce the result of the arithmetic.
    //Example
    //
    //url	response
    ///add/3/and/4	7
    ///subtract/3/from/10	7
    ///multiply/4/and/5	20
    ///divide/6/by/3	2

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public int add(@PathVariable int num1, @PathVariable int num2) {
        return num1 + num2;
    }


    @GetMapping("substarct/{num1}/and/{num2}")
    @ResponseBody
    public int substract(@PathVariable int num1, @PathVariable int num2) { return num1 -num2; }

    @GetMapping("multiply/{num1}/and/{num2}")
    @ResponseBody
    public int multiply(@PathVariable int num1, @PathVariable int num2) { return num1 * num2; }

    @GetMapping("divide/{num1}/and/{num2}")
    @ResponseBody
    public int divide(@PathVariable int num1, @PathVariable int num2) { return num1 / num2; }

    @GetMapping("modulus/{num1}/and/{num2}")
    @ResponseBody
    public int modulus(@PathVariable int num1, @PathVariable int num2) { return num1 % num2; }
}
