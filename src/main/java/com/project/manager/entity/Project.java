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
    private int employeeId;
}
