package com.project.manager.controller;

import com.project.manager.bean.request.AddTask;
import com.project.manager.bean.response.ViewParentTask;
import com.project.manager.bean.response.ViewTask;
import com.project.manager.entity.ParentTask;
import com.project.manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity createTask(@RequestBody AddTask createTask){
        boolean isTaskCreated = taskService.createTask(createTask);
        if(isTaskCreated)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping
    public ResponseEntity updateTask(@RequestBody AddTask updateTask){
        boolean isTaskUpdated = taskService.updateTask(updateTask);
        if(isTaskUpdated)
            return new ResponseEntity(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(path="/parent")
    public ResponseEntity getAllParentTask(){
        List<ViewParentTask> parentTask = taskService.getAllParentTask();
        if(parentTask!=null)
            return new ResponseEntity<>(parentTask,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity getTaskByProjectId(@RequestParam(value="projectId", required = true) String projectId){
        List<ViewTask> parentTask = taskService.getTaskByProjectId(projectId);
        if(parentTask!=null)
            return new ResponseEntity<>(parentTask,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping(path = "/completetask")
    public ResponseEntity completeTask(@RequestParam String taskId){
        boolean isTaskCompleted = taskService.completeTask(taskId);
        if(isTaskCompleted)
            return new ResponseEntity(HttpStatus.CREATED);
        else
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping
    public ResponseEntity deleteTask(@RequestParam String taskId){
        boolean isTaskDeleted = taskService.deleteTask(taskId);
        if(isTaskDeleted)
            return new ResponseEntity((HttpStatus.OK));
        else
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public void setTaskService(TaskService taskService){
        this.taskService = taskService;
    }
}
