package com.project.manager.service;

import com.project.manager.bean.request.AddProject;
import com.project.manager.entity.Project;

import java.util.List;

public interface ProjectService {
    public boolean createProject(AddProject user);
    public boolean updateProject(AddProject user);
    public List<Project> getAllProject();
    public boolean suspendProject(String projectId);
}

