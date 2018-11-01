package com.itglance.springboot.web.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
    public boolean isValid(String username,String password){
        return username.equalsIgnoreCase("ram")&&password.equals("ram123");
    }
}
