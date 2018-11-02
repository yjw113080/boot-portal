package com.examples.bootportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/members")
public class MemberController {
    @GetMapping("/login")
    public String login(){
        return "members/login"; // WEB-INF/jsp/members/login.jsp
    }
}
