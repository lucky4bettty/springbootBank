package com.example.h2_setup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2_setup.entity.Todo;
import com.example.h2_setup.service.TodoService;

@RestController
public class TodoController {
    @Autowired
    TodoService todoService;//取得Service物件

//    @GetMapping("/todos")
//    public Iterable<Todo> getTodoList () {
//        Iterable<Todo> todoList = todoService.getTodos();
//        return todoList;
//    }
    
    @PostMapping("/addTodo")
    public Todo saveTodo (@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }
    
    @GetMapping("/getTodo")
    public List<Todo> getAll () {
    	return todoService.getAllTodo();
    }
  
  	@PutMapping("/editTodo")
    public Todo updateTodo (@RequestBody Todo todo) {
        return todoService.editTodo(todo);
    }
  	
  	@DeleteMapping("/deleteTodo")
    public String deleteTodo (int todoId) {
        return todoService.deleteTodo(todoId);
    }
  	
}
