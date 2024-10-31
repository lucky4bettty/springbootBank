package com.example.h2_setup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.h2_setup.entity.Todo;
import com.example.h2_setup.repository.TodoRepository;

@Service
public class TodoService {
//    @Autowired
//    TodoDao todoDao; // 取得Dao物件
//
//    public Iterable<Todo> getTodos () {
//        return todoDao.findAll();
//    }
	
	@Autowired
	private TodoRepository repository;

	public Todo addTodo(Todo todo) {
		return repository.save(todo);
	}

	public List<Todo> getAllTodo() {
		return repository.findAll();
	}

	public Todo editTodo(Todo todo) {
		Todo existingTodo = repository.getReferenceById(todo.getId());
		existingTodo.setStatus(todo.getStatus());
		existingTodo.setTask(todo.getTask());
		
		return repository.save(existingTodo);
	}

	public String deleteTodo(int todoId) {
		repository.deleteById(todoId);
		return todoId + "delete successfully !!??";
	}
}
