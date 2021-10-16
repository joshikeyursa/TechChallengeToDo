package com.kjoshi.assessment.servian.todoapp.service;

import com.kjoshi.assessment.servian.todoapp.repo.ToDoRepo;
import com.kjoshi.assessment.servian.todoapp.vo.TaskBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
