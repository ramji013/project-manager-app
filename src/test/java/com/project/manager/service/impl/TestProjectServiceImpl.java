package com.project.manager.service.impl;

import com.project.manager.bean.request.AddProject;
import com.project.manager.entity.ParentTask;
import com.project.manager.entity.Project;
import com.project.manager.entity.Task;
import com.project.manager.repository.ProjectRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TestProjectServiceImpl {

    ProjectRepository projectRepository;
    ProjectServiceImpl projectService;

    @Before
    public void setUp(){
        projectRepository = mock(ProjectRepository.class);
        projectService = spy(ProjectServiceImpl.class);
        projectService.setProjectRepository(projectRepository);
    }

    @Test
    public void testCreateProject(){
        Assert.assertTrue(projectService.createProject(getProjectFromReq()));
    }

    @Test
    public void testUpdateProject(){
        when(projectRepository.getProjectById(any(Integer.class))).thenReturn(getProjectFromDB());
        Assert.assertTrue(projectService.updateProject(getProjectFromReq()));
    }

    @Test
    public void testUpdateProjectFailure(){
        when(projectRepository.getProjectById(any(Integer.class))).thenReturn(null);
        Assert.assertFalse(projectService.updateProject(getProjectFromReq()));
    }

    @Test
    public void testGetAllProject(){
        when(projectRepository.getAllActiveProject()).thenReturn(Arrays.asList(getProjectFromDB()));
        Assert.assertNotNull(projectService.getAllProject());
    }

    @Test
    public void testSuspendProject(){
        doNothing().when(projectRepository).suspendProject(any());
        Assert.assertTrue(projectService.suspendProject("123"));
    }

    public Project getProjectFromDB(){
        Project addProject = new Project();
        addProject.setEndDate(new Date());
        addProject.setStartDate(new Date());
        addProject.setManagerId(123);
        addProject.setPriority(1);
        addProject.setProjectName("Test");
        Task task = new Task();
        task.setEndDate(new Date());
        task.setStartDate(new Date());
        task.setUserId("123");
        task.setProjectId("123");
        task.setProject(addProject);
        task.setTask("This is task");
        task.setStatus("Y");
        ParentTask parentTask = new ParentTask();
        parentTask.setTaskDetail(Arrays.asList(task));
        parentTask.setParentTask("123");
        task.setParentId(parentTask);
        addProject.setTask(Arrays.asList(task));
        return addProject;
    }


    public AddProject getProjectFromReq(){
        AddProject addProject = new AddProject();
        addProject.setEndDate("2019-11-02");
        addProject.setStartDate("2019-11-02");
        addProject.setManagerId(123);
        addProject.setPriority(1);
        addProject.setProjectName("Test");
        return addProject;
    }
}
