package com.project.manager.service.impl;

import com.project.manager.bean.request.AddTask;
import com.project.manager.entity.ParentTask;
import com.project.manager.entity.Project;
import com.project.manager.entity.Task;
import com.project.manager.repository.ParentTaskRepository;
import com.project.manager.repository.TaskRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Transactional
public class TestTaskServiceImpl {

    TaskServiceImpl taskService;
    TaskRepository taskRepository;
    ParentTaskRepository parentTaskRepository;

    @Before
    public void setUp(){
        taskService = spy(TaskServiceImpl.class);
        taskRepository = mock(TaskRepository.class);
        parentTaskRepository = mock(ParentTaskRepository.class);
        taskService.setTaskRepository(taskRepository);
        taskService.setParentTaskRepository(parentTaskRepository);
    }

    @Test
    public void testCompleteTask(){
        doNothing().when(taskRepository).completeTask(any());
        Assert.assertTrue(taskService.completeTask(any()));
    }

    @Test
    public void testCreateParentTask(){
        Assert.assertTrue(taskService.createTask(getTaskFromReq(true)));
    }

    @Test
    public void testCreateParentTaskFailed(){
        Assert.assertFalse(taskService.createTask(null));
    }

    @Test
    public void testCreateChildTask(){
        Assert.assertTrue(taskService.createTask(getTaskFromReq(false)));
    }

    public AddTask getTaskFromReq(boolean isParent){
        AddTask addTask = new AddTask();
        addTask.setEndDate("2019-01-01");
        addTask.setParentTask(isParent);
        addTask.setPriority("1");
        addTask.setParentTaskId(1);
        addTask.setProjectId("1");
        //addTask.setProjectName("Test");
        addTask.setStartDate("2019-01-01");
        addTask.setTaskName("Hello");
        addTask.setUserId("123");
       // addTask.setParentId("123");
        return addTask;
    }

    @Test
    public void testAllParentTask(){
        when(parentTaskRepository.findAll()).thenReturn(Arrays.asList(getParentTaskFromDB()));
        Assert.assertTrue(taskService.getAllParentTask().size()>0);
    }

    @Test
    public void testTaskByProjectId(){
        when(taskRepository.findByProjectId(any())).thenReturn(getTask());
        Assert.assertTrue(taskService.getTaskByProjectId("").size()>0);
    }

    @Test
    public void testUpdateTask(){
        when(taskRepository.findByTaskId(any())).thenReturn(getTask().get(0));
        Assert.assertTrue(taskService.updateTask(getTaskFromReq(true)));
    }

    @Test
    public void testDeleteTask(){
        doNothing().when(taskRepository).deleteTask(any());
        Assert.assertTrue(taskService.deleteTask(any()));
    }

    public ParentTask getParentTaskFromDB(){
        ParentTask parentTask = getParentTask();
        parentTask.setTaskDetail(getTask());
        return parentTask;
    }

    public ParentTask getParentTask(){
        ParentTask parentTask = new ParentTask();
        parentTask.setParentTask("it is parent task");
        parentTask.setId(1);
        return parentTask;
    }

    public List<Task> getTask(){
        Task task = new Task();
        task.setStatus("Y");
        task.setTask("task");
        task.setProjectId("1");
        task.setStartDate(new Date());
        task.setEndDate(new Date());
        task.setIsCompleted("Y");
        task.setParentId(getParentTask());
        Project project = new Project();
        project.setProjectName("This is the project");
        project.setIsActive("Y");
        project.setManagerId(1232);
        project.setStartDate(new Date());
        project.setEndDate(new Date());
        project.setPriority(1);
        project.setProjectId("1");
        task.setProject(project);
        return Arrays.asList(task);
    }

}
