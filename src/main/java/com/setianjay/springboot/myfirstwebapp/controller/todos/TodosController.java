package com.setianjay.springboot.myfirstwebapp.controller.todos;

import com.setianjay.springboot.myfirstwebapp.service.todo.TodosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodosController {
    private final TodosService todosService;

    public TodosController(TodosService todosService){
        this.todosService = todosService;
    }
    @GetMapping("/todos")
    public String listToDosPage(Model model){
        model.addAttribute("todos", todosService.getTodos());
        return "user/todos";
    }
}
