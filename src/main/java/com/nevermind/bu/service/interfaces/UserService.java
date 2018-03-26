package com.nevermind.bu.service.interfaces;

import com.nevermind.bu.entity.User;

public interface UserService {

    User getById(int id);

    User getByUserName(String userName);
}
