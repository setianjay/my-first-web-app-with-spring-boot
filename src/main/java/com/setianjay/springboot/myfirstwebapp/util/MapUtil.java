package com.setianjay.springboot.myfirstwebapp.util;

import com.setianjay.springboot.myfirstwebapp.model.Todo;
import com.setianjay.springboot.myfirstwebapp.model.TodoArg;
import com.setianjay.springboot.myfirstwebapp.model.entity.TodoEntity;

import java.util.List;

public class MapUtil {

    /*-------------------------
    * Mapping TodoEntity
    *------------------------- */
    public static List<Todo> mapListTodoEntityToListTodo(List<TodoEntity> todoEntities) {
        return todoEntities.stream().map(todoEntity ->
                        new Todo(
                                todoEntity.getId(),
                                todoEntity.getUsername(),
                                todoEntity.getDescription(),
                                todoEntity.getTargetDate(),
                                todoEntity.isDone()))
                .toList();
    }

    public static Todo mapTodoEntityToTodo(TodoEntity todoEntity) {
        return new Todo(
                todoEntity.getId(),
                todoEntity.getUsername(),
                todoEntity.getDescription(),
                todoEntity.getTargetDate(),
                todoEntity.isDone()
        );
    }

    /*-------------------------
     * Mapping Todo
     *------------------------- */
    public static TodoArg mapTodoToTodoArg(Todo todo){
        return new TodoArg(todo.getUsername(), todo.getDescription(), todo.getTargetDate(), todo.isDone());
    }

    /*-------------------------
     * Mapping TodoArg
     *------------------------- */
    public static TodoEntity mapTodoArgToTodoEntity(TodoArg todoArg) {
        return new TodoEntity(0L, todoArg.getUsername(), todoArg.getDescription(), todoArg.getTargetDate(), todoArg.isDone());
    }

    public static TodoEntity mapTodoArgToTodoEntity(long id, TodoArg todoArg) {
        return new TodoEntity(id, todoArg.getUsername(), todoArg.getDescription(), todoArg.getTargetDate(), todoArg.isDone());
    }
}
