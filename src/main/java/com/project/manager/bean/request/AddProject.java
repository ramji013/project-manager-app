package com.project.manager.bean.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddProject {
    private int projectId;
    private String projectName;
    private String startDate;
    private String endDate;
    private int priority;
    private int managerId;
}
