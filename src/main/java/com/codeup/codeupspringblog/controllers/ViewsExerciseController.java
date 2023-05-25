package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewsExerciseController {
    //    //Create a page at /roll-dice that asks the user to guess a number. There should be links on this page for 1 through 6 that should make a GET request to /roll-dice/n where n is the number guessed. This page should display a random number (the dice roll), the user's guess and a message based on whether or not they guessed the correct number.

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDiceGuess(@PathVariable int guess, Model model) {
        int random = (int) Math.floor(Math.random() * 6 + 1);
        model.addAttribute("guess", guess);
        model.addAttribute("random", random);
        if (guess == random) {
            model.addAttribute("message", "You guessed the correct number! You guessed " + guess + " and the number was " + random + "!");
        } else {
            model.addAttribute("message", "You guessed the wrong number! You guessed " + guess + " and the number was " + random + "!");
        }
        System.out.println("random number was " + random);
        System.out.println(guess);
        return "roll-dice";
    }




}
