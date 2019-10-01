package com.project.manager.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity @Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class User implements Serializable {
    @Id
    private int userId;
    private int employeeId;
    private String firstName;
    private String lastName;

    /*public User(int userId, int employeeId, String firstName, String lastName){
        if(userId!=0)
            this.userId = userId;
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
    }*/
}
