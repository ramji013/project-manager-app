package com.project.manager.service;

import com.project.manager.bean.request.AddTask;
import com.project.manager.bean.response.ViewParentTask;
import com.project.manager.bean.response.ViewTask;

import java.util.List;

public interface TaskService {
    public boolean updateTask(AddTask task);
    public boolean completeTask(String taskId);
    public boolean createTask(AddTask task);
    List<ViewParentTask> getAllParentTask();

    List<ViewTask> getTaskByProjectId(String projectId);
}
