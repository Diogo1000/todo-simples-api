package com.diogodev.todospring.controller;

import com.diogodev.todospring.model.Tasks;
import com.diogodev.todospring.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private TasksService tasksService;

    @GetMapping
    public List<Tasks> getAllTasks(){
        return tasksService.getAllTasks();
    }

    @PostMapping
    public Tasks createTasks(@RequestBody Tasks tasks){
        return tasksService.createTasks(tasks);
    }

    @GetMapping("/{id}")
    public Tasks getTasksById(@PathVariable Long id){
        return tasksService.getTasksById(id);
    }

    @PutMapping("/{id}")
    public Tasks uptadeTasks(@PathVariable Long id, @RequestBody Tasks newTasks){
        return tasksService.uptadeTasks(newTasks);
    }

    @DeleteMapping("/{id}")
    public void deleteTasks(@PathVariable long id){
        tasksService.deleteTasks(id);
    }
}
