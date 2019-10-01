package com.project.manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity @Getter @Setter @NoArgsConstructor
public class Project implements Serializable {
    @Id
    @Column(name = "project_id")
    private int projectId;
    private String project;
    private Date startDate;
    private Date endDate;
    private int priority;

    public Project (int projectId, String project, Date startDate, Date endDate, int priority){
        if(projectId!=0)
            this.projectId = projectId;
        this.project = project;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
    }
}
