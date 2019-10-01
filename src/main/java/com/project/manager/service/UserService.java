package com.project.manager.service;

import com.project.manager.bean.request.AddUser;
import com.project.manager.bean.response.ViewUser;

import java.util.List;

public interface UserService {
    public boolean createUserData(AddUser user);
    public boolean updateUserData(AddUser user);
    public List<ViewUser> getAllUser();
}
