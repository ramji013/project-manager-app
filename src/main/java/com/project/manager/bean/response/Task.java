package com.project.manager.bean.response;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Task {
    private String taskName;
    private String taskId;
    private int priority;
    private String startDate;
    private String endDate;
}
