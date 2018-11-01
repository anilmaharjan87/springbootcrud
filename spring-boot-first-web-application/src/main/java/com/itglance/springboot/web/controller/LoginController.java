package com.itglance.springboot.web.controller;

import com.itglance.springboot.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {
    //LoginService service=new LoginService();
    @Autowired
    LoginService service;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginMessage(Model model){
       /*model.addAttribute("names",name);*/
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String afterLoginMessage(@RequestParam String name, @RequestParam String password, Model model){
        if(service.isValid(name,password)){
            model.addAttribute("name",name);
            model.addAttribute("password",password);
            return "logged-in";
        }
        String msg="invalid credentials";
        model.addAttribute("error",msg);
      return "login";
    }
}
