package com.springboot.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blibli.oss.common.response.Response;
import com.blibli.oss.common.response.ResponseHelper;
import com.springboot.demo.model.entity.Todo;
import com.springboot.demo.service.TodoService;
import io.swagger.annotations.Api;

@Api(value = "Todo Controller")
@RestController
public class TodoController {

  @Autowired
  private TodoService todoService;

  @PostMapping("/api/todo")
  public Response<Todo> createTodo(
      @RequestParam String username,
      @RequestParam String title,
      @RequestParam String description) {
    return ResponseHelper.ok(todoService.createTodo(username, title, description));
  }

  @DeleteMapping("/api/todo")
  public Response<Boolean> deleteTodo(
      @RequestParam String username,
      @RequestParam String title) {
    return ResponseHelper.ok(todoService.deleteTodo(username, title));
  }

  @GetMapping("/api/todo")
  public Response<List<Todo>> getTodos(
      @RequestParam String username) {
    return ResponseHelper.ok(todoService.getMemberTodos(username));
  }

}
