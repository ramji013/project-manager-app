package com.project.manager.service.impl;

import com.project.manager.bean.request.AddParentTask;
import com.project.manager.bean.request.AddTask;
import com.project.manager.bean.response.ViewTask;
import com.project.manager.entity.ParentTask;
import com.project.manager.entity.Task;
import com.project.manager.repository.ParentTaskRepository;
import com.project.manager.repository.TaskRepository;
import com.project.manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private ParentTaskRepository parentTaskRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public boolean createTask(AddTask task) {
        return false;
    }

    @Override
    public boolean updateTask(AddTask task) {
        return false;
    }

    @Override
    public List<ViewTask> getAllTask() {
        return null;
    }

    @Override
    public boolean completeTask(String taskId) {
        return false;
    }

    @Override
    public boolean createParentTask(AddTask createTask) {
        try {
            ParentTask parentTask = new ParentTask();
            Task task = new Task();
            if (createTask.isParentTask()){
               parentTask.setParentTask(createTask.getTaskName());
            }else {
                task.setTask(createTask.getTaskName());
            }
            task.setParentId(parentTask);
            task.setProjectId(createTask.getProjectId());
            parentTask.setTaskDetail(Arrays.asList(task));
            parentTaskRepository.save(parentTask);
            return true;
        }catch(Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }
}

