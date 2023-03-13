package com.setianjay.springboot.myfirstwebapp.repository;

import com.setianjay.springboot.myfirstwebapp.model.Todo;
import com.setianjay.springboot.myfirstwebapp.model.TodoArg;

import java.util.List;

public interface TodoRepository {
    void addTodo(TodoArg todoArg);

    void deleteTodoById(long id);

    Todo findTodoById(long id);

    List<Todo> getAllTodosByUsername(String username);

    void updateTodoById(long id, TodoArg todoArg);
}
