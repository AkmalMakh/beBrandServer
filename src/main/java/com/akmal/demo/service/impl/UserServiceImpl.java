package com.akmal.demo.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akmal.demo.io.entity.UserEntity;
import com.akmal.demo.repository.UserEntityRepository;
import com.akmal.demo.service.UserService;
import com.akmal.demo.shared.dto.UserDto;


@Service
public class UserServiceImpl implements UserService{
 
    @Autowired
    UserEntityRepository userRepository;
    
    @Override
    public UserDto createUser(UserDto user) {
        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("test");
        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto retunrValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, retunrValue);
        
        return retunrValue;
    }
    
}
