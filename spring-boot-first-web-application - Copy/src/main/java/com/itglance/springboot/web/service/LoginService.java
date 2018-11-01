package com.itglance.springboot.web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

@Service
@SessionAttributes("name")
public class LoginService {
    public boolean isValid(String name,String password){
        return name.equals("ram")&&password.equals("ram123");
    }
}
