package com.example.h2_setup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2_setup.entity.Bank;
import com.example.h2_setup.entity.Todo;
import com.example.h2_setup.service.BankService;
import com.example.h2_setup.service.TodoService;

@RestController
public class BankController {
	
    @Autowired
    BankService service;//取得Service物件
    
    @PostMapping("/addBank")
    public Bank saveTodo (@RequestBody Bank todo) {
        return service.addTodo(todo);
    }
    
    @GetMapping("/getBank")
    public List<Bank> getAll () {
    	return service.getAllTodo();
    }
  
  	@PutMapping("/editBank")
    public Bank updateTodo (@RequestBody Bank todo) {
        return service.editTodo(todo);
    }
  	
  	@DeleteMapping("/deleteBank")
    public String deleteTodo (int id) {
        return service.deleteTodo(id);
    }

}
