package com.project.manager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("task")
public class TaskController {
    @GetMapping
    public ResponseEntity getUser(){
        return  new ResponseEntity<>("task", HttpStatus.OK);
    }
}
