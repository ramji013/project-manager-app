package com.project.manager.controller;

import com.project.manager.bean.request.AddUser;
import com.project.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity createUser(@RequestBody AddUser user){
        boolean isCreated = userService.createUser(user);
        if(isCreated)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody AddUser user){
        boolean isUpdated = userService.updateUser(user);
        if(isUpdated)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity getUser(){
      return  new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

   @DeleteMapping
    public ResponseEntity deleteUser(@RequestParam String employeeId){
        boolean isDeleted = userService.deleteUser(employeeId);
        if(isDeleted)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public void setUserService(UserService userService){
        this.userService = userService;
    }
}
