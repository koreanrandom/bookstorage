package com.molport.bookstorage.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Home {
    @RequestMapping("/")
    public String showMenu() {
        return "redirect:/book/listBooks";
    }
}

