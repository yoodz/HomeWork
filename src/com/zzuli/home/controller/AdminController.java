package com.zzuli.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/page/admin")
public class AdminController {

    @RequestMapping(value = "/turn", method = RequestMethod.GET)
    public ModelAndView turn() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
    
        return modelAndView;
    }
}

