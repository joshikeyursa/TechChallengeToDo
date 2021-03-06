package com.kjoshi.assessment.servian.todoapp.controller;

import com.kjoshi.assessment.servian.todoapp.service.ToDoService;
import com.kjoshi.assessment.servian.todoapp.vo.TaskBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class ToDoController {

    @Autowired
    private final ToDoService service;

    public ToDoController(ToDoService service){
        this.service = service;
    }

    @GetMapping("/api")
    public ResponseEntity<List<TaskBean>> getAllTasks(){
        HttpStatus returnStatus = HttpStatus.OK;
        try{
            return ResponseEntity.ok(service.fetchAllTasks());
        }catch (Exception e){
            returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(returnStatus).body(new ArrayList<TaskBean>());
    }

    @GetMapping("/api/{taskId}")
    public ResponseEntity<TaskBean> getTaskById(@PathVariable("taskId") String taskId){
        Optional<TaskBean> taskRecord = service.getTaskById(taskId);
        if(taskRecord.isPresent()){
            TaskBean task = taskRecord.get();
            service.deleteTask(task);
            return ResponseEntity.ok(task);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/api")
    public ResponseEntity<TaskBean> createTask(@RequestBody TaskBean taskBean){
        taskBean.setId(UUID.randomUUID().toString());
        return ResponseEntity.ok(service.createTask(taskBean));
    }

    @DeleteMapping("/api/{taskId}")
    public ResponseEntity<TaskBean> deleteTask(@PathVariable("taskId")  String taskId){
        Optional<TaskBean> taskRecord = service.getTaskById(taskId);
        if(taskRecord.isPresent()){
            TaskBean task = taskRecord.get();
            service.deleteTask(task);
            return ResponseEntity.ok(task);
        }else{
           return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
