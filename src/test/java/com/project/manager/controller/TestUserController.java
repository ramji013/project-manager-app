package com.project.manager.controller;

import com.project.manager.entity.User;
import com.project.manager.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TestUserController {

    private UserService userService;
    private UserController userController;
    ResponseEntity responseEntity;

    @Before
    public void setUp(){
        userService = mock(UserService.class);
        userController = spy(UserController.class);
        userController.setUserService(userService);
    }

    @Test
    public void testCreateUserSuccess(){
        when(userService.createUser(any())).thenReturn(true);
        responseEntity = userController.createUser(any());
        Assert.assertEquals(201, responseEntity.getStatusCode().value());
    }

    @Test
    public void testCreateUserFailure(){
        when(userService.createUser(any())).thenReturn(false);
        responseEntity = userController.createUser(any());
        Assert.assertEquals(500, responseEntity.getStatusCode().value());
    }

    @Test
    public void testUpdateUserSuccess(){
        when(userService.updateUser(any())).thenReturn(true);
        responseEntity = userController.updateUser(any());
        Assert.assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCode().value());
    }

    @Test
    public void testUpdateUserFailure(){
        when(userService.updateUser(any())).thenReturn(false);
        responseEntity = userController.updateUser(any());
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), responseEntity.getStatusCode().value());
    }

    @Test
    public void testGetAllUser(){
        when(userService.getAllUser()).thenReturn(getUser());
        responseEntity = userController.getUser();
        List<User> users = (List<User>) responseEntity.getBody();
        Assert.assertEquals(200, responseEntity.getStatusCode().value());
        Assert.assertEquals("Employee ID not matching", "123", users.get(0).getEmployeeId());
        Assert.assertEquals("FirstName not matching", "firstname", users.get(0).getFirstName());
        Assert.assertEquals("LastName not matching", "lastName", users.get(0).getLastName());
        Assert.assertEquals("Active user not matching", "Y", users.get(0).getIsActive());
        Assert.assertEquals("UserId not matching", 1, users.get(0).getUserId());
    }

    @Test
    public void testDeleteUserSuccess(){
        when(userService.deleteUser(any())).thenReturn(true);
        responseEntity = userController.deleteUser(any());
        Assert.assertEquals(200, responseEntity.getStatusCode().value());
    }

    @Test
    public void testDeleteUserFailure(){
        when(userService.deleteUser(any())).thenReturn(false);
        responseEntity = userController.deleteUser(any());
        Assert.assertEquals(500, responseEntity.getStatusCode().value());
    }

    public List<User> getUser(){
        User user = new User();
        user.setEmployeeId("123");
        user.setFirstName("firstname");
        user.setLastName("lastName");
        user.setIsActive("Y");
        user.setUserId(1);
        return Arrays.asList(user);
    }
}
