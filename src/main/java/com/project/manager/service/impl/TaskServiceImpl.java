package com.project.manager.service.impl;

import com.project.manager.bean.request.AddTask;
import com.project.manager.bean.response.ViewParentTask;
import com.project.manager.bean.response.ViewTask;
import com.project.manager.entity.ParentTask;
import com.project.manager.entity.Task;
import com.project.manager.repository.ParentTaskRepository;
import com.project.manager.repository.TaskRepository;
import com.project.manager.service.TaskService;
import com.project.manager.util.ProjectManagerUtility;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private ParentTaskRepository parentTaskRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public boolean updateTask(AddTask task) {
        return false;
    }

    @Override
    public List<ViewTask> getAllTask() {
        List<Task> taskList = taskRepository.findAll();
        ViewTask viewTask = new ViewTask();
        List<ViewTask> viewTaskList = new ArrayList<>();
        for(Task task: taskList){
            if("Y".equalsIgnoreCase(task.getStatus())) {
                viewTask = new ViewTask();
                viewTask.setParentTaskId(task.getParentId().getId());
                viewTask.setParentTaskName(task.getParentId().getParentTask());
                viewTask.setProjectId(task.getProjectId());
                viewTask.setTaskName(task.getTask());
                viewTask.setPriority(task.getPriority());
                viewTask.setStartDate(ProjectManagerUtility.date2String(task.getStartDate()));
                viewTask.setEndDate(ProjectManagerUtility.date2String(task.getEndDate()));
                viewTaskList.add(viewTask);
            }
        }
        return viewTaskList;
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
            task.setProjectId(createTask.getProjectId());
            task.setStatus("Y");
            task.setStartDate(ProjectManagerUtility.str2Date(createTask.getStartDate()));
            task.setEndDate(ProjectManagerUtility.str2Date(createTask.getEndDate()));
            task.setPriority(createTask.getPriority());
            task.setUserId(createTask.getUserId());
            parentTask.setTaskDetail(Arrays.asList(task));
            parentTaskRepository.save(parentTask);
            return true;
        }catch(Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ViewParentTask> getAllParentTask() {
        List<ParentTask> parentTaskList = parentTaskRepository.findAll();
        ViewParentTask viewParentTask = new ViewParentTask();
        List<ViewParentTask> viewParentTaskList = new ArrayList<>();
        for(ParentTask parentTask: parentTaskList){
            viewParentTask = new ViewParentTask();
            viewParentTask.setParentId(parentTask.getId());
            viewParentTask.setTask(parentTask.getParentTask());
            viewParentTaskList.add(viewParentTask);
        }
        return viewParentTaskList;
        //List<com.project.manager.bean.response.ViewParentTask> parentTask = new ArrayList<>();
      //  return false;
    }

    @Override
    public List<ViewTask> getTaskByProjectId(String projectId) {
        List<Task> parentTaskList = taskRepository.findByProjectId(projectId);
        ViewTask viewTask = new ViewTask();
        List<ViewTask> viewTaskList = new ArrayList<>();
        for(Task task: parentTaskList){
            viewTask = new ViewTask();
            viewTask.setParentTaskId(task.getParentId().getId());
            viewTask.setParentTaskName(task.getParentId().getParentTask());
            viewTask.setProjectId(task.getProjectId());
            viewTask.setTaskName(task.getTask());
            viewTask.setPriority(task.getPriority());
            viewTask.setStartDate(ProjectManagerUtility.date2String(task.getStartDate()));
            viewTask.setEndDate(ProjectManagerUtility.date2String(task.getEndDate()));
            viewTaskList.add(viewTask);
        }
        return viewTaskList;
    }
}

