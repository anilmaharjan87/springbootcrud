package com.itglance.springboot.web.controller;

import com.itglance.springboot.web.dao.StudentDaoImpl;
import com.itglance.springboot.web.model.Student;
import com.itglance.springboot.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller

public class DefaultController {
    @Autowired
    LoginService service;

    @Autowired
    private StudentDaoImpl studentDao;

    @RequestMapping(value="/",method = RequestMethod.GET)

    public String homePage(Model model){
        model.addAttribute("name",getLoggedInUserName());

        return "home";
    }

    @RequestMapping("/showMyLoginPage")
    public String showCustomLogin(){
        return "custom-login";
    }


    @RequestMapping("/show-list")
    public String showList(Model model){

            List<Student> theStudents=studentDao.showList();
            model.addAttribute("students",theStudents);
            return "show-list";
    }

    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String showForm(Model model){
        return "add";
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)

    public String addStudent(@ModelAttribute Student student){
        studentDao.addStudent(student);
        return "redirect:/show-list";
    }

    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)

    public String deleteStudent(@PathVariable int id){
     /*   if(id==3)
        {
            throw new RuntimeException("error occured");
        }*/
        studentDao.deleteStudent(id);
        return "redirect:/show-list";
    }

    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)

    public String getStudent(@PathVariable int id,Model model){
        model.addAttribute("student",studentDao.getStudentById(id));
        return "update-form";
    }


    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String updateStudent(@ModelAttribute("student")Student theStudent){
        studentDao.updateStudent(theStudent);
        return "redirect:/show-list";
    }

    //to get user name
    private String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();

        return principal.toString();
    }


    @RequestMapping("/leaders")
    public String showLeaders(){
        return "leaders-page";
    }

    @RequestMapping("/systems")
    public String showAdmins(){
        return "admin-page";
    }

    @RequestMapping("/access-denied")
    public String showDeniedPage(){
        return "access-denied";
    }

}
