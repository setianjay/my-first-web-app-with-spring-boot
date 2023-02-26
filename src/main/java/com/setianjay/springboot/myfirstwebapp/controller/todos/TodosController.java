package com.setianjay.springboot.myfirstwebapp.controller.todos;

import com.setianjay.springboot.myfirstwebapp.service.todo.TodosService;
import com.setianjay.springboot.myfirstwebapp.util.FormatUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TodosController {
    private final TodosService todosService;

    public TodosController(TodosService todosService) {
        this.todosService = todosService;
    }

    @GetMapping("/todos")
    public String ToDosPage(Model model) {
        model.addAttribute("todos", todosService.getTodos());
        return "user/todos";
    }

    @GetMapping("/todos/create")
    public String createTodoPage() {
        return "user/createTodoForm";
    }

    @PostMapping("/todos/create")
    public RedirectView createTodo(
            @RequestParam("description") String description,
            @RequestParam("targetDate") String targetDate,
            Model model
    ) {
        String username = (String) model.asMap().get("username");
        todosService.addTodo(username, description, FormatUtil.generalDateFormat(targetDate));
        return new RedirectView("/todos");
    }
}
