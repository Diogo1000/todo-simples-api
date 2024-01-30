package com.diogodev.todospring.service;

import com.diogodev.todospring.model.Tasks;
import com.diogodev.todospring.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {

    @Autowired
    private TasksRepository tasksRepository;

    public List<Tasks> getAllTasks(){
        return tasksRepository.findAll();
    }

    public Tasks createTasks(Tasks tasks){
        return tasksRepository.save(tasks);
    }

    public Tasks getTasksById(Long id){
        return tasksRepository.findById(id).orElseThrow(()-> new RuntimeException("Tarefa não encontrada" + id));
    }

    public Tasks uptadeTasks(Tasks tasks){
        Tasks newTasks = getTasksById(tasks.getId());
        newTasks.setTaskTitle(tasks.getTaskTitle());
        newTasks.setTaskDescription(tasks.getTaskDescription());
        newTasks.setTaskCompleted(tasks.getTaskCompleted());
        return tasksRepository.save(newTasks);
    }

    public void deleteTasks(Long id){
        Tasks tasks = getTasksById(id);
        try {
            tasksRepository.delete(tasks);
        }catch (Exception e){
            throw new RuntimeException("Não e possivel deletar!");
        }

    }

}
