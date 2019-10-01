package com.project.manager.service.impl;

import com.project.manager.bean.request.AddUser;
import com.project.manager.bean.response.ViewUser;
import com.project.manager.entity.User;
import com.project.manager.repository.UserRepository;
import com.project.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean createUserData(AddUser user) {
        //User userBean = User.;
        //user.ge
        //user
        return false;
    }

    @Override
    public boolean updateUserData(AddUser user) {
        return false;
    }

    @Override
    public List<ViewUser> getAllUser() {
        return null;
    }
}
