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
        when(taskService.createTask(any())).thenReturn(true);
        responseEntity = taskController.createTask(any());
        Assert.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    public void testCreateTaskFailed(){
        when(taskService.createTask(any())).thenReturn(false);
        responseEntity = taskController.createTask(any());
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    @Test
    public void testUpdatesTaskSucces(){
        when(taskService.updateTask(any())).thenReturn(true);
        responseEntity = taskController.updateTask(any());
        Assert.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    public void testUpdatesTaskFailure(){
        when(taskService.updateTask(any())).thenReturn(false);
        responseEntity = taskController.updateTask(any());
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
        List<ViewTask> viewTasks = (List<ViewTask>)responseEntity.getBody();
        Assert.assertEquals("EndDate not matching","2019-01-01",viewTasks.get(0).getEndDate());
        Assert.assertEquals("StartDate not matching","2019-01-01",viewTasks.get(0).getStartDate());
        Assert.assertEquals("Priority not matching", "1", viewTasks.get(0).getPriority());
        Assert.assertEquals("Task name not matching", "123", viewTasks.get(0).getTaskName());
        Assert.assertEquals("Task completed flag not matching", true, viewTasks.get(0).isTaskCompleted());
        Assert.assertEquals("Parent Name not matching", "12321", viewTasks.get(0).getParentTaskName());
        Assert.assertEquals("ParentTask Id not matching", 1, viewTasks.get(0).getParentTaskId());
        Assert.assertEquals("Project id not matching", "12", viewTasks.get(0).getProjectId());
        Assert.assertEquals("Project name not matching", "1232", viewTasks.get(0).getProjectName());
        Assert.assertEquals("User id not matching", "123", viewTasks.get(0).getUserId());
        Assert.assertEquals("Task id not matching", 123, viewTasks.get(0).getTaskId());
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

    @Test
    public void testDeleteTaskSuccess(){
        when(taskService.deleteTask(any())).thenReturn(true);
        responseEntity = taskController.deleteTask(any());
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testDeleteTaskFailure(){
        when(taskService.deleteTask(any())).thenReturn(false);
        responseEntity = taskController.deleteTask(any());
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
        viewTask.setEndDate("2019-01-01");
        viewTask.setStartDate("2019-01-01");
        viewTask.setPriority("1");
        viewTask.setTaskName("123");
        viewTask.setTaskCompleted(true);
        viewTask.setParentTaskName("12321");
        viewTask.setParentTaskId(1);
        viewTask.setProjectId("12");
        viewTask.setProjectName("1232");
        viewTask.setUserId("123");
        viewTask.setTaskId(123);
        return Arrays.asList(viewTask);
    }
}
