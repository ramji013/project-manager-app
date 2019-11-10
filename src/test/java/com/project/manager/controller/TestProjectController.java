package com.project.manager.controller;

import com.project.manager.bean.response.ViewProject;
import com.project.manager.service.ProjectService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(SpringRunner.class)
//@SpringBootTest
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

//    private MockMvc mockMvc;
//
//    @Before
//    public void init(){
//        this.mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();
//    }

//    @Test
//    public void testCreateProjectSuccessIntegration() throws Exception{
//        mockMvc.perform(MockMvcRequestBuilders.post("/project/")
//                .contentType(MediaType.APPLICATION_JSON).content("{\"projectId\" : 1, \"projectName\" : \"First Project\", \"startDate\": \"2019-01-01\", \"endDate\": \"2019-02-10\", \"priority\": 10, \"managerId\" : \"1234\"}").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated());
//    }

//    @Test
//    public void testCreateProjectFailure() throws Exception{
//        mockMvc.perform(MockMvcRequestBuilders.post("/project/")
//                .contentType(MediaType.APPLICATION_JSON).content("").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isInternalServerError());
//    }

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
        List<ViewProject> viewProjects = (List<ViewProject>)responseEntity.getBody();
        Assert.assertEquals("Project completion status not matching", 1, viewProjects.get(0).getCompleted());
        Assert.assertEquals("ProjectName not matching", "123", viewProjects.get(0).getProjectName());
        Assert.assertEquals("Priority not matching", 1, viewProjects.get(0).getPriority());
        Assert.assertEquals("Number of task not matching", 1, viewProjects.get(0).getNoOfTask());
        Assert.assertEquals("StartDate not matching", "2019-01-01", viewProjects.get(0).getStartDate());
        Assert.assertEquals("EndDate not matching", "2019-01-01", viewProjects.get(0).getEndDate());
        Assert.assertEquals("Manager not matching", 12321, viewProjects.get(0).getManagerId());
        Assert.assertEquals("ProjectId not matching", "123", viewProjects.get(0).getProjectId());
        Assert.assertEquals("TaskStatus not matching", "Y", viewProjects.get(0).getTaskStatus());
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
