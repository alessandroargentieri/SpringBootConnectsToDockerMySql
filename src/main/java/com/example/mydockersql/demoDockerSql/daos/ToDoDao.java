package com.example.mydockersql.demoDockerSql.daos;

import com.example.mydockersql.demoDockerSql.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoDao extends JpaRepository<ToDo, Integer>{
}
