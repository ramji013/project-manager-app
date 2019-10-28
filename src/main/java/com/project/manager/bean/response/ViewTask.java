package com.project.manager.bean.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class ViewTask {
    private List<Task> task;
    private String parentTask;
    private String parentTaskId;
}
