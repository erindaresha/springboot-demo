package com.springboot.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.model.entity.Member;
import com.springboot.demo.model.entity.Todo;
import com.springboot.demo.repository.MemberRepository;
import com.springboot.demo.repository.TodoRepository;
import com.springboot.demo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

  @Autowired
  private TodoRepository todoRepository;

  @Autowired
  private MemberRepository memberRepository;

  @Override
  public Todo createTodo(String username, String title, String description) {
    Member member = memberRepository.findOne(username);

    if (member == null) {
      throw new RuntimeException("Member not found");
    }

    if (todoRepository.countByMember_UsernameAndTitle(username, title) > 0) {
      throw new RuntimeException("Todo with given title already existed");
    }

    Todo todo = Todo.builder()
        .id(UUID.randomUUID().toString())
        .title(title)
        .description(description)
        .member(member)
        .build();

    return todoRepository.save(todo);
  }

  @Override
  public boolean deleteTodo(String username, String title) {
    if (todoRepository.countByMember_UsernameAndTitle(username, title) == 0) {
      return false;
    } else {
      deleteTodo(username, title);
      return true;
    }
  }

  @Override
  public List<Todo> getMemberTodos(String username) {
    if (memberRepository.findOne(username) == null) {
      throw new RuntimeException("Member not found");
    }

    return todoRepository.findAllByMember_Username(username);
  }

}
