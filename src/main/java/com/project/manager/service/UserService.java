package com.project.manager.service;

import com.project.manager.bean.request.AddUser;
import com.project.manager.entity.User;

import java.util.List;

public interface UserService {
    public boolean createUser(AddUser user);
    public boolean updateUser(AddUser user);
    public List<User> getAllUser();
    boolean deleteUser(String employeeId);
}
