package com.example.todo.entity.DTO;

import com.example.todo.entity.Todo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class TodoDTO {

    private String title;
    private String description;

    public Todo convertToEntity() {
        return new Todo().setTitle(this.title)
                .setDescription(this.description)
                .setDate(LocalDateTime.now());

    }
}
