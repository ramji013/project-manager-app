package com.project.manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity @Getter @Setter @NoArgsConstructor
public class Task implements Serializable {
    @Id
    private int taskId;
    private int parentId;
    private int projectId;
    private String task;
    private Date startDate;
    private Date endDate;
    private int priority;
    private String status;

    public Task(int taskId, int parentId, int projectId, String task, Date startDate, Date endDate, int priority, String status){
        if(taskId!=0)
            this.taskId = taskId;
        this.parentId = parentId;
        this.projectId = projectId;
        this.task = task;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
        this.status = status;
    }
}
