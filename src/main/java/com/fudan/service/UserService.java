package com.fudan.service;


import com.fudan.dao.UserDao;
import com.fudan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(Integer id){
        return userDao.selectByPrimaryKey(id);
    }

}
