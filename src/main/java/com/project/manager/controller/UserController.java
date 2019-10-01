package com.project.manager.controller;

import com.project.manager.bean.request.AddUser;
import com.project.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity createUser(@RequestBody AddUser user){
        boolean isCreated = userService.createUserData(user);
        if(isCreated)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody AddUser user){
        boolean isUpdated = userService.updateUserData(user);
        if(isUpdated)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity getUser(){
      return  new ResponseEntity<>(userService.getAllUser(), HttpStatus.ACCEPTED);
    }
}
