package com.example.todo.service.implementations;

import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Override
    public Todo addTodo(Todo todo) {
        if (todo == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return todoRepository.save(todo);
    }

    @Override
    public Todo getById(Integer id) {

        return todoRepository.getOne(id);
    }

    @Override
    public Todo update(Todo todo) {
        if (todoRepository.existsById(todo.getId())) {
            return todoRepository.save(todo);
        } else {
            throw new ResourceNotFoundException(
                    String.format("Category with id '%s' not found", todo.getId()));
        }
    }

    @Override
    public void delete(Integer todoId) {
        if (todoId == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        try {
            todoRepository.deleteById(todoId);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(String.format("Category with id '%s' not found", todoId));
        }
    }

    @Override
    public List<Todo> getAll() {

        return todoRepository.findAll();
    }

    @Override
    public List<Todo> getByTitle(String title) {
        return todoRepository.findByTitle(title);
    }

    @Override
    public List<Todo> getByDate(LocalDateTime dateTime) {

        return todoRepository.findByDate(dateTime);
    }
}
