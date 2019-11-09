package com.project.manager.controller;

import com.project.manager.bean.response.ViewParentTask;
import com.project.manager.bean.response.ViewTask;
import com.project.manager.service.TaskService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class TestTaskController {

    private TaskController taskController;
    private TaskService taskService;
    ResponseEntity responseEntity;

    @Before
    public void setUp(){
        taskController = spy(TaskController.class);
        taskService = mock(TaskService.class);
        taskController.setTaskService(taskService);
    }

    @Test
    public void testCreateTask(){
        when(taskService.createParentTask(any())).thenReturn(true);
        responseEntity = taskController.createTask(any());
        Assert.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    public void testCreateTaskFailed(){
        when(taskService.createParentTask(any())).thenReturn(false);
        responseEntity = taskController.createTask(any());
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    @Test
    public void testgetAllParentTask(){
        when(taskService.getAllParentTask()).thenReturn(getParentTask());
        responseEntity = taskController.getAllParentTask();
        List<ViewParentTask> parentTasks = (List<ViewParentTask>)responseEntity.getBody();
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertEquals(1, parentTasks.get(0).getParentId());
        Assert.assertEquals("12", parentTasks.get(0).getTask());
    }

    @Test
    public void testGetAllParentTaskFailure(){
        when(taskService.getAllParentTask()).thenReturn(null);
        responseEntity = taskController.getAllParentTask();
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    @Test
    public void testGetTaskByProjectId(){
        when(taskService.getTaskByProjectId(any())).thenReturn(getTask());
        responseEntity = taskController.getTaskByProjectId(any());
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testGetTaskByProjectIdFailure(){
        when(taskService.getTaskByProjectId(any())).thenReturn(null);
        responseEntity = taskController.getTaskByProjectId(any());
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    @Test
    public void testCompleteTaskSuccess(){
        when(taskService.completeTask(any())).thenReturn(true);
        responseEntity = taskController.completeTask(any());
        Assert.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    public void testCompleteTaskFailure(){
        when(taskService.completeTask(any())).thenReturn(false);
        responseEntity = taskController.completeTask(any());
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    public List<ViewParentTask> getParentTask(){
        ViewParentTask viewParentTask = new ViewParentTask();
        viewParentTask.setTask("12");
        viewParentTask.setParentId(1);
        return Arrays.asList(viewParentTask);
    }

    public List<ViewTask> getTask(){
        ViewTask viewTask = new ViewTask();
        viewTask.setTaskCompleted(true);
        viewTask.setEndDate("1232");
        viewTask.setStartDate("12321");
        viewTask.setPriority("1");
        viewTask.setTaskName("123");
        viewTask.setTaskCompleted(true);
        viewTask.setParentTaskName("12321");
        viewTask.setParentTaskId(1);
        viewTask.setProjectId("12");
        viewTask.setProjectName("1232");
        viewTask.setUserId("123");
        return Arrays.asList(viewTask);
    }
}
