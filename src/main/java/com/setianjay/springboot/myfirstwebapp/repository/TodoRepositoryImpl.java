package com.setianjay.springboot.myfirstwebapp.repository;

import com.setianjay.springboot.myfirstwebapp.data.local.LocalTodoDataSource;
import com.setianjay.springboot.myfirstwebapp.model.Todo;
import com.setianjay.springboot.myfirstwebapp.model.TodoArg;
import com.setianjay.springboot.myfirstwebapp.util.MapUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepositoryImpl implements TodoRepository {
    private final LocalTodoDataSource localTodoDataSource;

    public TodoRepositoryImpl(LocalTodoDataSource localTodoDataSource){
        this.localTodoDataSource = localTodoDataSource;
    }

    @Override
    public void addTodo(TodoArg todoArg) {
        localTodoDataSource.save(MapUtil.mapTodoArgToTodoEntity(todoArg));
    }

    @Override
    public void deleteTodoById(long id) {
        localTodoDataSource.deleteById(id);
    }

    @Override
    public Todo findTodoById(long id) {
        return MapUtil.mapTodoEntityToTodo(localTodoDataSource.findById(id).get());
    }

    @Override
    public List<Todo> getAllTodosByUsername(String username) {
        return MapUtil.mapListTodoEntityToListTodo(localTodoDataSource.findAllByUsername(username));
    }

    @Override
    public void updateTodoById(long id, TodoArg todoArg) {
        localTodoDataSource.save(MapUtil.mapTodoArgToTodoEntity(id, todoArg));
    }
}
