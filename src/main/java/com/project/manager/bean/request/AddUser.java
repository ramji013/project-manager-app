package com.project.manager.bean.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddUser {
   // private String userId;
    private String firstName;
    private String lastName;
    private String employeeId;
}
