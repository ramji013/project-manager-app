package com.project.manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity @Getter @Setter @NoArgsConstructor
public class Task implements Serializable {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;

    @ManyToOne
    @JoinColumn(name= "parent_id", referencedColumnName = "id")
    private ParentTask parentId;
    @Column(name="project_id")
    private String projectId;
    private String task;
    private Date startDate;
    private Date endDate;
    private String priority;
    private String status;
    @Column(name="user_id")
    private String userId;
    @Column(name="is_completed")
    private String isCompleted;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name="project_id", referencedColumnName="project_id", insertable = false, updatable = false)
    })
    private Project project;

}
