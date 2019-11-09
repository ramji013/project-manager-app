package com.project.manager;

import com.project.manager.bean.response.TestViewParentTask;
import com.project.manager.bean.response.TestViewProject;
import com.project.manager.controller.TestProjectController;
import com.project.manager.controller.TestTaskController;
import com.project.manager.controller.TestUserController;
import com.project.manager.service.impl.TestProjectServiceImpl;
import com.project.manager.service.impl.TestTaskServiceImpl;
import com.project.manager.service.impl.TestUserServiceImpl;
import com.project.manager.util.TestProjectManagerUtility;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestProjectController.class,
        TestTaskController.class,
        TestUserController.class,
        TestProjectServiceImpl.class,
        TestTaskServiceImpl.class,
        TestUserServiceImpl.class,
        TestProjectManagerUtility.class,
        TestViewParentTask.class,
        TestViewProject.class
})
public class TestSuite {

}
