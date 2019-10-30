package com.project.manager.bean.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

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
}
