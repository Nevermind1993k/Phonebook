package com.nevermind.bu.service.interfaces;

import com.nevermind.bu.entity.User;
import com.nevermind.bu.exception.UserExistException;

public interface UserService {

    User getById(int id);

    User getByUsername(String username);

    User registerNewUserAccount(User user) throws UserExistException;
}
