package com.project.manager.bean.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddTask {
    private String projectName;
    private String projectId;
    private String taskName;
    @JsonProperty("isParentTask")
    private boolean isParentTask;
    private String priority;
    private String parentTaskId;
    private String startDate;
    private String endDate;
    private String userId;
    private String parentId;
    private String taskId;
}
