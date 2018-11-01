package com.itglance.springboot.web.controller;

import com.itglance.springboot.web.model.Todo;
import com.itglance.springboot.web.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {
    @Autowired
    TodoService service;

    @RequestMapping(value = "/todo-list",method = RequestMethod.GET)
    public String showTodo(ModelMap model){
        String name=(String)model.get("name");
        model.put("todos",service.retrieveTodos(name));
        return "todo-list";
    }
    @RequestMapping(value = "/add-todo",method = RequestMethod.GET)
    public String showAddForm(Model model){
        return "add-todo";
    }
    @RequestMapping(value = "/add-todo",method = RequestMethod.POST)
    public String AddTodo(ModelMap model, @RequestParam String desc){
        service.addTodo((String) model.get("name"),desc,new Date(),false);
        return "redirect:/todo-list";
    }

    @RequestMapping(value = "/delete-todo/{id}",method = RequestMethod.GET)
    public String DeleteTodo(@PathVariable int id){
      service.deleteTodo(id);
        return "redirect:/todo-list";
    }



   /* @RequestMapping(value = "/delete-todo",method = RequestMethod.GET)
    public String DeleteTodo(@RequestParam int id){
        service.deleteTodo(id);
        return "redirect:/todo-list";
    }
*/

}
