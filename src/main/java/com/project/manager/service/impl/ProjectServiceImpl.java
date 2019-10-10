package com.project.manager.service.impl;

import com.project.manager.bean.request.AddProject;
import com.project.manager.entity.Project;
import com.project.manager.repository.ProjectRepository;
import com.project.manager.service.ProjectService;
import com.project.manager.util.ProjectManagerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public boolean createProject(AddProject user) {
        try {
            Project project = new Project();
            project.setProject(user.getProject());
            project.setStartDate(ProjectManagerUtility.str2Date(user.getStartDate()));
            project.setEndDate(ProjectManagerUtility.str2Date(user.getEndDate()));
            project.setPriority(user.getPriority());
            project.setEmployeeId(user.getEmployeeId());
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
            projectData.setEmployeeId(user.getEmployeeId());
            projectData.setPriority(user.getPriority());
            projectData.setEndDate(ProjectManagerUtility.str2Date(user.getEndDate()));
            projectData.setStartDate(ProjectManagerUtility.str2Date(user.getStartDate()));
            projectData.setProject(user.getProject());
            projectRepository.save(projectData);
            return true;
        }
        return false;
    }

    @Override
    public List<Project> getAllProject() {
        return projectRepository.getAllActiveProject();
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
