package com.project.manager.bean.response;

import org.junit.Assert;
import org.junit.Test;

public class TestViewParentTask {

    @Test
    public void testViewParentTask(){
        ViewParentTask viewParentTask = new ViewParentTask();
        viewParentTask.setParentId(1);
        viewParentTask.setTask("12");
        Assert.assertEquals(1, viewParentTask.getParentId());
        Assert.assertEquals("12", viewParentTask.getTask());
    }
}
