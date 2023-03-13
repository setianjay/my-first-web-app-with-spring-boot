package com.setianjay.springboot.myfirstwebapp.service.todo;

import com.setianjay.springboot.myfirstwebapp.model.Todo;
import com.setianjay.springboot.myfirstwebapp.model.TodoArg;
import com.setianjay.springboot.myfirstwebapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodosService {
    private final TodoRepository todoRepository;

    public TodosService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodosByUsername(String username) {
        return todoRepository.getAllTodosByUsername(username);
    }

    public void addTodo(TodoArg todoArg) {
        todoRepository.addTodo(todoArg);
    }

    public void deleteTodoById(long id) {
        todoRepository.deleteTodoById(id);
    }

    public Todo findTodoById(long id) {
        return todoRepository.findTodoById(id);
    }

    public void updateTodoById(long id, TodoArg updateTodo) {
        todoRepository.updateTodoById(id, updateTodo);
    }
}
