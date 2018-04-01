package com.nevermind.bu.service;

import com.nevermind.bu.dao.UserDao;
import com.nevermind.bu.entity.User;
import com.nevermind.bu.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import exception.UserExistException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getById(int id) {
        return userDao.findById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User registerNewUserAccount(User user) throws UserExistException {
        try {
            return userDao.save(user);
        } catch (Exception e) {
            throw new UserExistException();
        }
    }
}
