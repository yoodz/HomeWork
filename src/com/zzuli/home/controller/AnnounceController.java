package com.zzuli.home.controller;

import java.util.List;

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
@RequestMapping("/page/announce")
public class AnnounceController {

    @Resource
    private AnnounceService announceService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public MessageEntry add(@RequestBody Announce announce, HttpServletRequest request) {
        boolean userDb = announceService.add(announce);
        return JsonMessage.ok(userDb);
    }
    
    @ResponseBody
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public MessageEntry find(@RequestBody HttpServletRequest request) {
        List<Announce> announce = announceService.find();
        return JsonMessage.ok(announce);
    }
}

