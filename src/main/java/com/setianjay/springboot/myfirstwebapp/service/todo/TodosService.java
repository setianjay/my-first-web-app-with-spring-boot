package com.setianjay.springboot.myfirstwebapp.service.todo;

import com.setianjay.springboot.myfirstwebapp.model.Todo;
import com.setianjay.springboot.myfirstwebapp.model.TodoArg;
import com.setianjay.springboot.myfirstwebapp.util.FormatUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodosService {
    private final static List<Todo> todos = new ArrayList<>();
    private static long todoIdCounter = 0L;

    static {
        todos.add(new Todo(++todoIdCounter, "setianjay", "Learn Android", LocalDate.now().plusYears(1L), false));
        todos.add(new Todo(++todoIdCounter, "setianjay", "Learn Spring Boot", LocalDate.now().plusYears(1L), false));
        todos.add(new Todo(++todoIdCounter, "setianjay", "Learn Clean Architecture", LocalDate.now().plusYears(1L), false));
    }

    public List<Todo> getTodosByUsername(String username) {
        return todos.stream().filter(todo -> todo.getUsername().equals(username)).toList();
    }

    public void addTodo(TodoArg todoArg) {
        Todo todo = new Todo(
                ++todoIdCounter,
                todoArg.getUsername(),
                todoArg.getDescription(),
                FormatUtil.generalDateFormat(todoArg.getTargetDate().toString()),
                todoArg.isDone()
        );
        todos.add(todo);
    }

    public void deleteTodoById(long id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo findTodoById(long id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().orElseThrow();
    }

    public void updateTodoById(long id, TodoArg newTodo) {
        Todo changedTodo = findTodoById(id);
        int indexOfChangedToDo = todos.indexOf(changedTodo);

        if (indexOfChangedToDo != -1) {
            changedTodo.setDescription(newTodo.getDescription());
            changedTodo.setTargetDate(newTodo.getTargetDate());
            changedTodo.setDone(newTodo.isDone());
            todos.set(indexOfChangedToDo, changedTodo);
        }
    }
}
