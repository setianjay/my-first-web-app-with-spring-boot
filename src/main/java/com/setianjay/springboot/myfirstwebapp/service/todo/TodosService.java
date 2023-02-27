package com.setianjay.springboot.myfirstwebapp.service.todo;

import com.setianjay.springboot.myfirstwebapp.model.Todo;
import com.setianjay.springboot.myfirstwebapp.model.TodoArg;
import com.setianjay.springboot.myfirstwebapp.util.FormatUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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

    public List<Todo> getTodos() {
        return Collections.unmodifiableList(todos);
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
}
