package com.nevermind.bu.service;

import com.nevermind.bu.dao.UserDao;
import com.nevermind.bu.entity.User;
import com.nevermind.bu.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getById(int id) {
        return userDao.findById(id);
    }

    @Override
    public User getByUserName(String userName) {
        return userDao.findByUserName(userName);
    }
}
