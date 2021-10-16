package com.kjoshi.assessment.servian.todoapp.controller;

import com.kjoshi.assessment.servian.todoapp.service.ToDoService;
import com.kjoshi.assessment.servian.todoapp.vo.TaskBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoController {

    @Autowired
    private final ToDoService service;

    public ToDoController(ToDoService service){
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<TaskBean>> getAllTasks(){
        HttpStatus returnStatus = HttpStatus.OK;
        try{
            return ResponseEntity.ok(service.fetchAllTasks());
        }catch (Exception e){
            returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(returnStatus).body(new ArrayList<TaskBean>());
    }
}
