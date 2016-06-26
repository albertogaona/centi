package com.albertogaona.centi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by alberto on 19/06/16.
 */
@Controller
public class DefaultController {

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
    
    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }
    

}

