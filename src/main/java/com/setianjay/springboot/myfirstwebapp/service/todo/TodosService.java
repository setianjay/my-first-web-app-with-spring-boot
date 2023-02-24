package com.setianjay.springboot.myfirstwebapp.service.todo;

import com.setianjay.springboot.myfirstwebapp.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TodosService {
    private final static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "setianjay", "Learn Android", LocalDate.now().plusYears(1L), false));
        todos.add(new Todo(2, "setianjay", "Learn Spring Boot", LocalDate.now().plusYears(1L), false));
        todos.add(new Todo(3, "setianjay", "Learn Clean Architecture", LocalDate.now().plusYears(1L), false));
    }

    public List<Todo> getTodos() {
        return Collections.unmodifiableList(todos);
    }
}
