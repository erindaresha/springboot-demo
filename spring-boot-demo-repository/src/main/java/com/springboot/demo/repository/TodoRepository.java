package com.springboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.model.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, String> {

  long countByMember_UsernameAndAndTitle(String username, String title);

  List<Todo> findAllByMember_Username(String username);

}
