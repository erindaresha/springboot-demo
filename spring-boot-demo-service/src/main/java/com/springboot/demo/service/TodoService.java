package com.springboot.demo.service;

import java.util.List;

import com.springboot.demo.model.entity.Todo;

public interface TodoService {

  Todo createTodo(String username, String title, String description);

  List<Todo> getMemberTodos(String username);

}
