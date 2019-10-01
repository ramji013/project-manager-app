package com.project.manager.bean.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddTask {

    private String project;
    private String projectId;
    private String task;
    private boolean isParenetTask;
    private String priority;
    private String parentTask;
    private String startDate;
    private String endDate;
}
