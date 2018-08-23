package com.example.todo.service;

import com.example.todo.entity.Todo;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoService {
    Todo addTodo(Todo todo);

    Todo getById(Integer id);

    Todo update(Todo todo);

    void delete(Integer todoId);

    List<Todo> getAll();

    List<Todo> getByTitle(String title);

    List<Todo> getByDate(LocalDateTime dateTime);

}
