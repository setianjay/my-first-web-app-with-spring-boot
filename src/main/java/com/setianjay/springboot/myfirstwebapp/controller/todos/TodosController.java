package com.setianjay.springboot.myfirstwebapp.controller.todos;

import com.setianjay.springboot.myfirstwebapp.model.TodoArg;
import com.setianjay.springboot.myfirstwebapp.service.todo.TodosService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@SessionAttributes("username")
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
    public String createTodoPage(Model model) {
        String username = (String) model.asMap().get("username");
        /* default initialization for Todos bean for handle of binding object in here and view and set default value */
        TodoArg todo = (TodoArg) model.asMap().getOrDefault(
                "todo",
                new TodoArg(username, "", null, false));
        model.addAttribute("todo", todo);
        model.addAttribute("errorMessage", model.asMap().getOrDefault("errorMessage", ""));
        return "user/createTodoForm";
    }

    @PostMapping("/todos/create")
    public RedirectView createTodo(
            @Valid TodoArg todo,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {
                String errorMessage = error.getDefaultMessage();
                if (errorMessage != null) {
                    redirectAttributes.addFlashAttribute("todo", todo);
                    redirectAttributes.addFlashAttribute("errorMessage", error.getDefaultMessage());
                }
            }
            return new RedirectView("/todos/create");
        }
        todosService.addTodo(todo);
        return new RedirectView("/todos");
    }
}
