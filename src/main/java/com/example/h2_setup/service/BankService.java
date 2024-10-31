package com.example.h2_setup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.h2_setup.entity.Bank;
import com.example.h2_setup.repository.BankRepository;

@Service
public class BankService {
	
	@Autowired
	private BankRepository repository;

	public Bank addTodo(Bank bank) {
		return repository.save(bank);
	}

	public List<Bank> getAllTodo() {
		return repository.findAll();
	}

	public Bank editTodo(Bank data) {
		Bank existingData = repository.getReferenceById(data.getId());
		existingData.setCode(data.getCode());
		existingData.setDescription(data.getDescription());
		existingData.setRate(data.getRate());
		existingData.setUpdateTime(data.getUpdateTime());
		return repository.save(existingData);
	}

	public String deleteTodo(int id) {
		repository.deleteById(id);
		return id + " : delete successfully !!??";
	}

}
