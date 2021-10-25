package com.todoList.todoApp.controller;


import com.todoList.todoApp.entity.Todo;
import com.todoList.todoApp.service.TodoService;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public Todo saveTodo(@RequestBody Todo todo){
       return todoService.createTodo(todo);
    }

    @GetMapping
    public List<Todo> getAllTodoTask(){
      return todoService.getAllTodo();
    }

    @DeleteMapping("/{id}")
    public String deleteTodoTaskById(@PathVariable("id") Long id){
        todoService.deleteTodoById(id);
        return "Todo-Task is Successfully deleted";
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable("id") Long id){
        return todoService.getTodoById(id);
    }

    @PutMapping("/{id}")
    public Todo updateTodoTask(@PathVariable("id") Long id,@RequestBody Todo todo){
        return todoService.updateTodoItem(id,todo);
    }
}
