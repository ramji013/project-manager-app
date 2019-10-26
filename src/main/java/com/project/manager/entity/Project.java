package com.project.manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor
public class Project implements Serializable {
    @Id
    @Column(name = "project_id")
    private int projectId;
    @Column(name="project_name")
    private String projectName;
    private Date startDate;
    private Date endDate;
    private int priority;
    private int managerId;
    @Column(name="is_active")
    private String isActive;
    @OneToMany(fetch= FetchType.EAGER, mappedBy = "project")
    private List<Task> task;
}
