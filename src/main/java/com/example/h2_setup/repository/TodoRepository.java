package com.example.h2_setup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.h2_setup.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
