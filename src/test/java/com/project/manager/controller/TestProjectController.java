package com.project.manager.controller;

import com.project.manager.bean.response.ViewProject;
import com.project.manager.service.ProjectService;
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

public class TestProjectController {

    ProjectService projectService;
    ProjectController projectController;
    ResponseEntity responseEntity;

    @Before
    public void setUp(){
        projectService = mock(ProjectService.class);
        projectController = spy(ProjectController.class);
        projectController.setProjectService(projectService);
    }

    @Test
    public void testCreateProjectSuccess(){
        when(projectService.createProject(any())).thenReturn(true);
        responseEntity = projectController.createProject(any());
        Assert.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    public void testCreateProjectFailure(){
        when(projectService.createProject(any())).thenReturn(false);
        responseEntity = projectController.createProject(any());
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    @Test
    public void testUpdateProjectSuccess(){
        when(projectService.updateProject(any())).thenReturn(true);
        responseEntity = projectController.updateProject(any());
        Assert.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    public void testUpdateProjectFailure(){
        when(projectService.updateProject(any())).thenReturn(false);
        responseEntity = projectController.updateProject(any());
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    @Test
    public void testSuspendProjectSuccess(){
        when(projectService.suspendProject(any())).thenReturn(true);
        responseEntity = projectController.suspendProject(any());
        Assert.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    public void testSuspendProjectFailure(){
        when(projectService.suspendProject(any())).thenReturn(false);
        responseEntity = projectController.suspendProject(any());
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    @Test
    public void testGetAllProject(){
        when(projectService.getAllProject()).thenReturn(getProject());
        responseEntity = projectController.getAllProject();
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testGetAllProjectFailure(){
        when(projectService.getAllProject()).thenReturn(null);
        responseEntity = projectController.getAllProject();
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    private List<ViewProject> getProject(){
        ViewProject viewProject = new ViewProject();
        viewProject.setCompleted(1);
        viewProject.setProjectName("123");
        viewProject.setPriority(1);
        viewProject.setNoOfTask(1);
        viewProject.setEndDate("2019-01-01");
        viewProject.setStartDate("2019-01-01");
        viewProject.setManagerId(12321);
        viewProject.setProjectId("123");
        viewProject.setTaskStatus("Y");
        return Arrays.asList(viewProject);
    }
}
