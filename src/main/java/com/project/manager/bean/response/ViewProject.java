package com.project.manager.bean.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class ViewProject {
    private String projectId;
    private String projectName;
    private int noOfTask;
    private String startDate;
    private String endDate;
    private String taskStatus;
    private int priority;
    private int completed;
    private int managerId;
}
