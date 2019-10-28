package com.project.manager.controller;

import com.project.manager.bean.request.AddTask;
import com.project.manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity createTask(@RequestBody AddTask createTask){
        boolean isTaskCreated = taskService.createParentTask(createTask);
        if(isTaskCreated)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping
    public ResponseEntity getUser(){
        //boolean isTaskCreated = taskService.createParentTask(createParentTask);
//        if(isTaskCreated)
//            return new ResponseEntity<>(HttpStatus.OK);
//        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
