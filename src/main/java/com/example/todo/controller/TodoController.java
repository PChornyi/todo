package com.example.todo.controller;

import com.example.todo.entity.DTO.TodoDTO;
import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping(value = "/{id}")
    public Todo getById(@PathVariable Integer id) {
        return todoService.getById(id);
    }

    @GetMapping
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    @PutMapping
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo) {
        Todo updatedTodo = todoService.update(todo);

        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    @DeleteMapping("/{todoId}")
    public void deleteComment(@PathVariable Integer todoId) {
        todoService.delete(todoId);
    }

    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        return new ResponseEntity<>(todoService.addTodo(todo), HttpStatus.CREATED);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Todo> addTodoDTO(@RequestBody TodoDTO todo) {
        return new ResponseEntity<>(todoService.addTodo(todo.convertToEntity()), HttpStatus.CREATED);
    }

    @GetMapping(params = "title")
    public List<Todo> getByTitle(@RequestParam(value = "title") String title) {
        return todoService.getByTitle(title);
    }

    @GetMapping(params = "date")
    public List<Todo> getByDate(@RequestParam(value = "date") LocalDateTime date) {
        return todoService.getByDate(date);
    }

}
