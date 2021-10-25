package com.todoList.todoApp.repository;

import com.todoList.todoApp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
