package com.project.manager.service;

import com.project.manager.bean.request.AddParentTask;
import com.project.manager.bean.request.AddTask;
import com.project.manager.bean.response.ViewTask;

import java.util.List;

public interface TaskService {
    public boolean createTask(AddTask task);
    public boolean updateTask(AddTask task);
    public List<ViewTask> getAllTask();
    public boolean completeTask(String taskId);
    public boolean createParentTask(AddTask task);
}
