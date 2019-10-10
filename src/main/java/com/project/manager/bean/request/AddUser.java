package com.project.manager.bean.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class AddUser {
    @JsonProperty("userId")
    @Getter(AccessLevel.PUBLIC)
    private String userId;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("employeeId")
    private String employeeId;
}