package com.project.manager.service.impl;

import com.project.manager.bean.request.AddProject;
import com.project.manager.bean.response.ViewProject;
import com.project.manager.entity.Project;
import com.project.manager.entity.Task;
import com.project.manager.repository.ProjectRepository;
import com.project.manager.service.ProjectService;
import com.project.manager.util.ProjectManagerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public boolean createProject(AddProject user) {
        try {
            Project project = new Project();
            project.setProjectName(user.getProjectName());
            project.setStartDate(ProjectManagerUtility.str2Date(user.getStartDate()));
            project.setEndDate(ProjectManagerUtility.str2Date(user.getEndDate()));
            project.setPriority(user.getPriority());
            project.setManagerId(user.getManagerId());
            project.setIsActive("Y");
            projectRepository.save(project);
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateProject(AddProject user) {
        Project projectData = projectRepository.getProjectById(user.getProjectId());
        if(projectData!=null) {
            projectData.setManagerId(user.getManagerId());
            projectData.setPriority(user.getPriority());
            projectData.setEndDate(ProjectManagerUtility.str2Date(user.getEndDate()));
            projectData.setStartDate(ProjectManagerUtility.str2Date(user.getStartDate()));
            projectData.setProjectName(user.getProjectName());
            projectRepository.save(projectData);
            return true;
        }
        return false;
    }

    @Override
    public List<ViewProject> getAllProject() {
        List<Project> project= projectRepository.getAllActiveProject();
        List<ViewProject> viewProjects = new ArrayList<>();
        if(project!=null){
            for(Project projectBean: project){
                ViewProject viewProject = new ViewProject();
                viewProject.setStartDate(ProjectManagerUtility.date2String(projectBean.getStartDate()));
                viewProject.setEndDate(ProjectManagerUtility.date2String(projectBean.getEndDate()));
                viewProject.setPriority(projectBean.getPriority());
                viewProject.setProjectName(projectBean.getProjectName());
                viewProject.setProjectId(projectBean.getProjectId());
                viewProject.setManagerId(projectBean.getManagerId());
                int count = 0;
                if(projectBean.getTask()!=null) {
                    for(Task task: projectBean.getTask()) {
                        if("Y".equalsIgnoreCase(task.getStatus()))
                            count++;
                    }
                    viewProject.setCompleted(count);
                    viewProject.setNoOfTask(projectBean.getTask().size());
                }
                viewProjects.add(viewProject);
            }
        }
        return viewProjects;
    }

    @Override
    public boolean suspendProject(String projectId) {
        try {
            projectRepository.suspendProject(projectId);
            return true;
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return false;
    }
}
