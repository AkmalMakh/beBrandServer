package com.akmal.demo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akmal.demo.model.request.UserDetailsRequestModel;
import com.akmal.demo.model.response.UserDetailsResponseModel;
import com.akmal.demo.service.UserService;
import com.akmal.demo.shared.dto.UserDto;


@RestController
@RequestMapping("users")  
public class UserController{
    
    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(){
        return "get user was called";
    }

    @PostMapping 
    public UserDetailsResponseModel createUser(@RequestBody UserDetailsRequestModel userDetails){
        UserDetailsResponseModel returnValue = new UserDetailsResponseModel();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

    @PutMapping 
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }
    
}