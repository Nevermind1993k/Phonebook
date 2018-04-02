package com.nevermind.bu.service;


import com.nevermind.bu.entity.User;
import com.nevermind.bu.service.interfaces.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Mock
    @Autowired
    UserService userService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getByIdTest() throws Exception {
        User mockedUser = new User();
        mockedUser.setUsername("mocked");
        mockedUser.setPassword("mocked");
        mockedUser.setFirstName("mocked");
        mockedUser.setLastName("mocked");
        mockedUser.setMiddleName("mocked");
        mockedUser.setContacts(new ArrayList<>());

        when(userService.getById(anyInt())).thenReturn(mockedUser);
        User byId = userService.getById(555);
        assertEquals("mocked",byId.getUsername());

        verify(userService).getById(555);
    }

    @Test
    public void getByUsernameTest() throws Exception {
        User mockedUser = new User();
        mockedUser.setUsername("mocked");
        mockedUser.setPassword("mocked");
        mockedUser.setFirstName("mocked");
        mockedUser.setLastName("mocked");
        mockedUser.setMiddleName("mocked");
        mockedUser.setContacts(new ArrayList<>());

        when(userService.getByUsername(anyString())).thenReturn(mockedUser);
        User byUsername = userService.getByUsername("mocked");
        assertEquals("mocked",byUsername.getUsername());
    }

    @Test
    public void registerNewUserAccountTest() throws Exception {
        User user = new User();
        user.setUsername("New UserName");
        userService.registerNewUserAccount(user);
        verify(userService).registerNewUserAccount(user);
    }

}
