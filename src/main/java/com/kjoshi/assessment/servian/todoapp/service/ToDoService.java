package com.kjoshi.assessment.servian.todoapp.service;

import com.kjoshi.assessment.servian.todoapp.repo.ToDoRepo;
import com.kjoshi.assessment.servian.todoapp.vo.TaskBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    @Autowired
    private final ToDoRepo repo;

    public ToDoService(ToDoRepo repo){
        this.repo = repo;
    }

    public List<TaskBean> fetchAllTasks(){
        return repo.findAll();
    }

    public TaskBean createTask(TaskBean taskBean){
        return repo.save(taskBean);
    }

    public Optional<TaskBean> getTaskById(String taskId){
        return repo.findById(taskId);
    }

    public void deleteTask(TaskBean task){
        repo.delete(task);
    }
}
