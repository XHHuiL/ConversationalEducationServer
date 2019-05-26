package com.fudan.service;


import com.fudan.entity.User;
import com.fudan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

}
