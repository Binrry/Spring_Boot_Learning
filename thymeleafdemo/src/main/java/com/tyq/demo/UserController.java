package com.tyq.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.annotation.Resource;
import java.util.List;

    @Controller
    @RequestMapping("/users")
    public class UserController{

        @Resource
        private UserService userService;

        @RequestMapping("/test")
        public String test(Model model){
            List<User> userList=userService.findAll();
            model.addAttribute("users",userList);
            return "User";
        }

    @RequestMapping("/hello")
    public String index()
    {
        return "Hello,Binrry!";
    }

}