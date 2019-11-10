package com.project.manager.service.impl;

import com.project.manager.bean.request.AddUser;
import com.project.manager.entity.User;
import com.project.manager.repository.UserRepository;
import com.project.manager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public UserRepository userRepository;

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
            logger.error("Exception occured while creating user: ", exp);
        }
        return false;
    }

    @Override
    public boolean updateUser(AddUser user) {
        User userData = userRepository.getUserByEmployeeId(user.getEmployeeId());
        if (userData != null) {
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
            logger.error("Exception occured while deleting user: ", exp);
            return false;
        }
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
