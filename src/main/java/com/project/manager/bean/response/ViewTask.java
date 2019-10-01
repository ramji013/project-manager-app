package com.project.manager.bean.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class ViewTask {
    private String taskId;
    private String task;
    private String parentTask;
    private String parentTaskId;
    private int priority;
    private Date startDate;
    private Date endDate;
}
