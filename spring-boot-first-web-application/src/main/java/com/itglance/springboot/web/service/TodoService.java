package com.itglance.springboot.web.service;

import com.itglance.springboot.web.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos=new ArrayList<>();
    private static int todoCount=3;

    static {
        todos.add(new Todo(1,"ram","learn java",new Date(),false));
        todos.add(new Todo(2,"ram","learn angular",new Date(),true));
        todos.add(new Todo(3,"ram","learn python",new Date(),false));

    }

    public List<Todo> retrieveTodos(String user){
       List<Todo> filteredTodos=new ArrayList<>();
        for(Todo todo:todos){
            if(todo.getUser().equals(user)){
                filteredTodos.add(todo);
            }

        }
        return filteredTodos;
    }

    public void addTodo(String name,String desc,Date targetDate,boolean isDone){
        todos.add(new Todo(++todoCount,name,desc,targetDate,isDone));
    }

    public void deleteTodo(int id){
        for(Todo todo:todos){
            if(todo.getId()==id){
                todos.remove(todo);
            }
        }
    }

}
