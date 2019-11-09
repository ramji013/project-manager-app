package com.project.manager.bean.response;

import org.junit.Assert;
import org.junit.Test;

public class TestViewProject {

    @Test
    public void testViewProject(){
        ViewProject viewProject = new ViewProject();
        viewProject.setTaskStatus("Y");
        viewProject.setProjectId("1");
        viewProject.setManagerId(1);
        viewProject.setStartDate("2019-01-01");
        viewProject.setEndDate("2019-01-10");
        viewProject.setNoOfTask(1);
        viewProject.setPriority(1);
        viewProject.setProjectName("123");
        viewProject.setCompleted(1);

        Assert.assertEquals(1, viewProject.getManagerId());
    }
}
