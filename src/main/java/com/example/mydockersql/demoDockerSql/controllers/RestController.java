package com.example.mydockersql.demoDockerSql.controllers;

import com.example.mydockersql.demoDockerSql.daos.ToDoDao;
import com.example.mydockersql.demoDockerSql.entities.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    ToDoDao toDoDao;

    @RequestMapping("/")
    public String health(){
        return "service: UP";
    }

    @RequestMapping("/save")
    public ToDo saveToDo(@Valid ToDo toDo){
        return toDoDao.save(toDo);
    }

    @RequestMapping("/delete/{id}")
    public void deleteToDo(@PathVariable(value = "id") Integer id){
        toDoDao.delete(id);
    }

    @RequestMapping("/get/{id}")
    public ToDo getToDo(@PathVariable(value = "id") Integer id){
        return toDoDao.findOne(id);
    }

    @RequestMapping("/get")
    public List<ToDo> getAllToDos(){
        return toDoDao.findAll();
    }



}
