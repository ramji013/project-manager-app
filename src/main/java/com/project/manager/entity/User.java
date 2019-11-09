package com.project.manager.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity @Getter @Setter
public class User implements Serializable {
    @Id
    private int userId;
    private String employeeId;
    private String firstName;
    private String lastName;
    @Column(name="is_Active")
    private String isActive;

}
