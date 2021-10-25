package com.todoList.todoApp.service;

import com.todoList.todoApp.entity.Todo;
import com.todoList.todoApp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> getAllTodo() {
        List<Todo> todos = new ArrayList<>();
        todos.addAll(todoRepository.findAll());
        return todos;
    }

    @Override
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).get();
    }

    @Override
    public Todo updateTodoItem(Long id,Todo todo) {
        Todo todoDetail = todoRepository.findById(id).get();
        if(Objects.nonNull(todo.getTitle()) && !"".equalsIgnoreCase(todo.getTitle())){
             todoDetail.setTitle(todo.getTitle());
        }
        if(Objects.nonNull(todo.getDescription()) && !"".equalsIgnoreCase(todo.getDescription())){
            todoDetail.setDescription(todo.getDescription());

        }
        LocalDateTime date = LocalDateTime.now() ;
            todoDetail.setDateTime(date);


        return todoRepository.save(todoDetail);
    }
}
