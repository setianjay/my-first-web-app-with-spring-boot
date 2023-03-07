package com.setianjay.springboot.myfirstwebapp.controller.todos;

import com.setianjay.springboot.myfirstwebapp.model.Todo;
import com.setianjay.springboot.myfirstwebapp.model.TodoArg;
import com.setianjay.springboot.myfirstwebapp.service.todo.TodosService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        String username = (String) model.asMap().get("username");
        model.addAttribute("todos", todosService.getTodosByUsername(username));
        return "user/todos";
    }

    @GetMapping("/todos/create")
    public String createTodoPage(Model model) {
        String username = (String) model.asMap().get("username");
        /* default initialization for Todos bean for handle of binding object in here and view and set default value */
        Todo todo = (Todo) model.asMap().getOrDefault(
                "todo",
                new Todo(0L, username, "", null, false));
        model.addAttribute("todo", todo);
        model.addAttribute("errorMessage", model.asMap().getOrDefault("errorMessage", ""));
        return "user/createTodoForm";
    }

    @PostMapping("/todos/create")
    public RedirectView createTodo(
            @Valid Todo todo,
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

        TodoArg todoArg = new TodoArg(todo.getUsername(), todo.getDescription(), todo.getTargetDate(), todo.isDone());
        todosService.addTodo(todoArg);
        return new RedirectView("/todos");
    }

    @GetMapping("/todos/delete")
    public RedirectView deleteTodo(@RequestParam long id) {
        todosService.deleteTodoById(id);
        return new RedirectView("/todos");
    }

    @GetMapping("/todos/update")
    public String updateTodoPage(@RequestParam int id, Model model) {
        Todo todo = (Todo) model.asMap().getOrDefault("todo", todosService.findTodoById(id));
        model.addAttribute("todo", todo);
        model.addAttribute("errorMessage", model.asMap().getOrDefault("errorMessage", ""));
        return "user/updateTodoForm";
    }

    @PostMapping("/todos/update")
    public RedirectView updateTodoPage(@Valid Todo todo,
                                       BindingResult result,
                                       RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {
                String errorMessage = error.getDefaultMessage();
                if (errorMessage != null) {
                    redirectAttributes.addFlashAttribute("todo", todo);
                    redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
                }
            }

            return new RedirectView("/todos/update?id=" + todo.getId());
        }

        long todoId = todo.getId();
        TodoArg todoArg = new TodoArg(todo.getUsername(), todo.getDescription(), todo.getTargetDate(), todo.isDone());
        todosService.updateTodoById(todoId, todoArg);
        return new RedirectView("/todos");
    }
}
