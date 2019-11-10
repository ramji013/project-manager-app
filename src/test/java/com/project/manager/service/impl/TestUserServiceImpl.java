package com.project.manager.service.impl;

import com.project.manager.bean.request.AddUser;
import com.project.manager.entity.User;
import com.project.manager.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.Arrays;

import static org.mockito.Mockito.*;

@Transactional
public class TestUserServiceImpl {


    private UserRepository userRepository;
    private UserServiceImpl userService;

    @Before
    public void setUp(){
           userRepository = mock(UserRepository.class);
           userService = spy(UserServiceImpl.class);
           userService.setUserRepository(userRepository);
    }

    @Test
    public void testCreateUser(){
        Assert.assertTrue(userService.createUser(getUser()));
    }

    @Test
    public void testUpdateUser(){
        when(userRepository.getUserByEmployeeId(any())).thenReturn(getUserFromDB());
        Assert.assertTrue(userService.updateUser(getUser()));
    }

    @Test
    public void testAllUser(){
        when(userRepository.getAllActiveUser()).thenReturn((Arrays.asList(getUserFromDB())));
        Assert.assertNotNull(userService.getAllUser());
    }

    @Test
    public void testDeleteUser(){
        doNothing().when(userRepository).deleteEmployee(any());
        Assert.assertTrue(userService.deleteUser(any()));
    }

    public User getUserFromDB(){
        User user = new User();
        user.setLastName("lastname");
        user.setFirstName("firstName");
        user.setEmployeeId("123");
        return user;
    }

    public AddUser getUser(){
        AddUser addUser = new AddUser();
        addUser.setEmployeeId("123");
        addUser.setFirstName("abc");
        addUser.setLastName("bcd");
       // addUser.setUserId("123");
        return addUser;
    }
}
