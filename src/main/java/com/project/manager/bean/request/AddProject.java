package com.project.manager.bean.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddProject {
    private int projectId;
    private String projectName;
    private String startDate;
    private String endDate;
    private int priority;
    private int managerId;
}
