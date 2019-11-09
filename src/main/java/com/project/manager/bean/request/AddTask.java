package com.project.manager.bean.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddTask {
    private String projectName;
    private String projectId;
    private String taskName;
    @JsonProperty("isParentTask")
    private boolean isParentTask;
    private String priority;
    private int parentTaskId;
    private String startDate;
    private String endDate;
    private String userId;
    private String parentId;
    private String taskId;
}
