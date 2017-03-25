package com.zzuli.home.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zzuli.home.AppConstants;
import com.zzuli.home.AppContext;
import com.zzuli.home.base.JsonMessage;
import com.zzuli.home.base.JsonMessage.MessageEntry;
import com.zzuli.home.model.User;
import com.zzuli.home.service.UserService;

@Controller
@RequestMapping("/page/user")
public class UserController extends BaseController{

    private final String LOGIN_JSP = "login";
    private final String QUESTION_PAGE = "question/turn";

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "go", defaultValue = "") String go) {
        User user = this.getUser();
        ModelAndView modelAndView = new ModelAndView();

        if (user != null) {
            modelAndView.setView(this.getRedirectView(QUESTION_PAGE));
        } else {
            modelAndView.addObject("go", go);
            modelAndView.setViewName(LOGIN_JSP);
        }
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        session.removeAttribute(AppConstants.USER);
        session.invalidate();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(LOGIN_JSP);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public MessageEntry validate(@RequestBody User user, HttpServletRequest request) {
        User userDb = userService.validate(user);
        user.setPassword(null);
        this.addSession(AppConstants.USER, user);
        return JsonMessage.ok(userDb);
    }
}
