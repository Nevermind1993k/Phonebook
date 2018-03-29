package com.nevermind.bu.service.interfaces;

import com.nevermind.bu.entity.User;
import utilities.UserExistException;

public interface UserService {

    User getById(int id);

    User getByUserName(String userName);

    User registerNewUserAccount(User user) throws UserExistException;
}
