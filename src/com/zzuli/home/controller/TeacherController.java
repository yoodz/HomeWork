package com.zzuli.home.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zzuli.home.base.JsonMessage;
import com.zzuli.home.base.JsonMessage.MessageEntry;
import com.zzuli.home.model.Announce;
import com.zzuli.home.service.AnnounceService;

@Controller
@RequestMapping("/page/teacher")
public class TeacherController {

    @Resource
    private AnnounceService announceService;
    
    @RequestMapping(value = "/turn", method = RequestMethod.GET)
    public ModelAndView turn() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("teacher");
    
        return modelAndView;
    }

}

