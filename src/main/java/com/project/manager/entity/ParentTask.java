package com.project.manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Getter @Setter @NoArgsConstructor
public class ParentTask implements Serializable{
    @Column(name="parent_id")
    @Id
    private int parentId;
    private String task;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="parentId")
    private Task taskDetail;

    public ParentTask (int parentId, String task){
        if(parentId!=0)
            this.parentId = parentId;
        this.task = task;
    }

}
