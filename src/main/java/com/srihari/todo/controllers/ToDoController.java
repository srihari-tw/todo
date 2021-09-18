package com.srihari.todo.controllers;

import com.srihari.todo.model.TodoItem;
import com.srihari.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class ToDoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public List<TodoItem> findAll() {
        return todoRepository.findAll();
    }

    @PostMapping
    public TodoItem save(@Valid @NotNull @RequestBody TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    @PutMapping
    public TodoItem update(@Valid @NotNull @RequestBody TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        todoRepository.deleteById(id);
    }
}
