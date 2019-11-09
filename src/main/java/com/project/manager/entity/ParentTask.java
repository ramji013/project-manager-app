package com.project.manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity @Getter @Setter @NoArgsConstructor
public class ParentTask implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="parent_task",updatable = false, nullable = false)
    private String parentTask;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL ,mappedBy="parentId")
    private List<Task> taskDetail;


}
