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
    public boolean createUser(AddUser user) {
        try {
            User userBean = new User();
            userBean.setEmployeeId(user.getEmployeeId());
            userBean.setFirstName(user.getFirstName());
            userBean.setLastName(user.getLastName());
            userRepository.save(userBean);
            return true;
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(AddUser user) {
        User userData = userRepository.getUserByEmployeeId(user.getEmployeeId());
        if(userData!=null) {
            userData.setFirstName(user.getFirstName());
            userData.setLastName(user.getLastName());
            userRepository.save(userData);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        return (List<User>)userRepository.getAllActiveUser();
}

    @Override
    public boolean deleteUser(String employeeId) {
        try {
            userRepository.deleteEmployee(employeeId);
            return true;
        }catch (Exception exp){
            return false;
        }

    }
}
