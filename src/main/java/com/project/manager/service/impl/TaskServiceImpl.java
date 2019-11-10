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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private ParentTaskRepository parentTaskRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public boolean updateTask(AddTask updateTask) {

        Task task = taskRepository.findByTaskId(updateTask.getTaskId());
        if(task!=null) {
            task.setParentId(task.getParentId());
            task.setProjectId(updateTask.getProjectId());
            task.setStartDate(ProjectManagerUtility.str2Date(updateTask.getStartDate()));
            task.setEndDate(ProjectManagerUtility.str2Date(updateTask.getEndDate()));
            task.setPriority(updateTask.getPriority());
            task.setUserId(updateTask.getUserId());
            taskRepository.save(task);
        }
        return true;
    }


    @Override
    public boolean completeTask(String taskId) {
        taskRepository.completeTask(taskId);
        return true;
    }

    @Override
    public boolean createTask(AddTask createTask) {
        try {
            if(createTask.isParentTask()){
                ParentTask parentTask = new ParentTask();
                parentTask.setParentTask(createTask.getTaskName());
                parentTaskRepository.save(parentTask);
            }else {
                ParentTask parentTask = parentTaskRepository.getOne(createTask.getParentTaskId());
                Task task = new Task();
                task.setTask(createTask.getTaskName());
                task.setParentId(parentTask);
                task.setProjectId(createTask.getProjectId());
                task.setStatus("Y");
                task.setStartDate(ProjectManagerUtility.str2Date(createTask.getStartDate()));
                task.setEndDate(ProjectManagerUtility.str2Date(createTask.getEndDate()));
                task.setPriority(createTask.getPriority());
                task.setUserId(createTask.getUserId());
                //parentTask.setTaskDetail(Arrays.asList(task));
                taskRepository.save(task);
            }
            return true;
        }catch(Exception exp) {
            logger.error("Exception occured while creating task: ", exp);
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
    }

    @Override
    public List<ViewTask> getTaskByProjectId(String projectId) {
        List<Task> parentTaskList = taskRepository.findByProjectId(projectId);
        ViewTask viewTask = new ViewTask();
        List<ViewTask> viewTaskList = new ArrayList<>();
        for(Task task: parentTaskList){
            viewTask = new ViewTask();
            viewTask.setParentTaskId(task.getParentId().getId());
            viewTask.setParentTaskName(task.getParentId().getParentTask()==null ? "This task has no parent task" :
                    task.getParentId().getParentTask());
            viewTask.setProjectId(task.getProjectId());
            viewTask.setTaskName(task.getTask());
            viewTask.setPriority(task.getPriority());
            viewTask.setStartDate(ProjectManagerUtility.date2String(task.getStartDate()));
            viewTask.setEndDate(ProjectManagerUtility.date2String(task.getEndDate()));
            viewTask.setTaskId(task.getTaskId());
            viewTask.setTaskCompleted("Y".equalsIgnoreCase(task.getIsCompleted()));
            viewTask.setProjectName(task.getProject().getProjectName());
            viewTask.setUserId(task.getUserId());
            viewTaskList.add(viewTask);
        }
        return viewTaskList;
    }

    public void setTaskRepository(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public void setParentTaskRepository(ParentTaskRepository parentTaskRepository){
        this.parentTaskRepository = parentTaskRepository;
    }
}

