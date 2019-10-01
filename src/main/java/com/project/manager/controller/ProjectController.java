package com.project.manager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("project")
public class ProjectController {

    @GetMapping
    public ResponseEntity getUser(){
        return  new ResponseEntity<>("project", HttpStatus.ACCEPTED);
    }
}
