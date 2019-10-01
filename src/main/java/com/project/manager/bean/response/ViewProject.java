package com.project.manager.bean.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class ViewProject {
    private int projectId;
    private String project;
    private int noOfTask;
    private Date startDate;
    private Date endDate;
    private String taskStatus;
    private int priority;
}
