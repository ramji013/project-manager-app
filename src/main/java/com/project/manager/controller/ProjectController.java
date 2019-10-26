package com.project.manager.controller;

import com.project.manager.bean.request.AddProject;
import com.project.manager.bean.response.ViewProject;
import com.project.manager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity createProject(@RequestBody AddProject addProject) {
        boolean isCreated = projectService.createProject(addProject);
        if(isCreated)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity updateProject(@RequestBody AddProject addProject) {
        boolean isCreated = projectService.updateProject(addProject);
        if(isCreated)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping
    public ResponseEntity suspendProject(@RequestParam String projectId) {
        boolean isCreated = projectService.suspendProject(projectId);
        if(isCreated)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity getAllProject() {
        List<ViewProject> projectLst = projectService.getAllProject();
        if(projectLst!=null)
            return new ResponseEntity<>(projectLst, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
