package com.example.h2_setup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.h2_setup.Util.DateUtil;
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
		existingData.setUpdateTime(DateUtil.getNow());
		return repository.save(existingData);
	}

	public String deleteTodo(int id) {
		repository.deleteById(id);
		return "delete successfully:" + id;
	}

	public Bank getBankById(int id) {
		Optional<Bank> data = repository.findById(id);
		Bank emp = null;
		if(data.isPresent()) {
			emp=data.get();
		}else {
			throw new RuntimeException("not found : " + id);
		}
		return emp;
	}

}
