package com.todoList.todoApp.service;

import com.todoList.todoApp.entity.Todo;

import java.util.List;

public interface TodoService {

    Todo createTodo(Todo todo);

    List<Todo> getAllTodo();

    void deleteTodoById(Long id);

    Todo updateTodoItem(Long id, Todo todo);

    Todo getTodoById(Long id);

}
