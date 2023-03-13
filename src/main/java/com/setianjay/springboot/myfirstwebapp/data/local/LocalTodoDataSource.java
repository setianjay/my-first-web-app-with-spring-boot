package com.setianjay.springboot.myfirstwebapp.data.local;

import com.setianjay.springboot.myfirstwebapp.model.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalTodoDataSource extends JpaRepository<TodoEntity, Long> {

    List<TodoEntity> findAllByUsername(String username);
}
