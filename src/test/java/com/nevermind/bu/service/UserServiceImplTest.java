package com.nevermind.bu.service;

import org.junit.Assert;
import org.junit.Test;

public class UserServiceImplTest extends InitMockService {

    @Test
    public void getByUsernameTest() {
        Assert.assertEquals(mockUser, userService.getByUsername("mockedUser"));
    }

    @Test
    public void getByIdTest() {
        Assert.assertEquals(mockUser, userService.getById(1));
    }
}
