package com.springboot.springbootcrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class NavigationController {
    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        return view;
    }
}
