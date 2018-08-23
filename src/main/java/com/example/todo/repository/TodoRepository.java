package com.example.todo.repository;

import com.example.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.invoke.LambdaMetafactory;
import java.time.LocalDateTime;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByTitle(String title);

    List<Todo> findByDate(LocalDateTime date);

}
