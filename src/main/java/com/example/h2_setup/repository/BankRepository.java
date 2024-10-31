package com.example.h2_setup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.h2_setup.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer>{
	
	Optional<Bank> findByRate(String email);

}
