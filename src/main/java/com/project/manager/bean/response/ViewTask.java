package com.project.manager.bean.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ViewTask {
    private String projectName;
    private String projectId;
    private String taskName;
    private String parentTaskName;
    private String priority;
    private int parentTaskId;
    private String startDate;
    private String endDate;
    private String userId;
    private int taskId;
    private boolean taskCompleted;

}
