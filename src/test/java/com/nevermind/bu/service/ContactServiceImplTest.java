package com.nevermind.bu.service;

import com.nevermind.bu.entity.Contact;
import com.nevermind.bu.entity.User;
import com.nevermind.bu.service.interfaces.ContactService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ContactServiceImplTest {

    @Mock
    @Autowired
    ContactService contactService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getByIdTest() throws Exception {
        Contact mocked = new Contact();
        mocked.setFirstName("MockedContact");
        mocked.setLastName("MockedContact");
        mocked.setMiddleName("MockedContact");
        mocked.setMobilePhoneNumber("+380(66)1234567");
        mocked.setHomePhoneNumber("+380(44)1234567");
        mocked.setAddress("mockedAddress");
        mocked.setEmail("mockedEmail");
        mocked.setUser(new User());

        when(contactService.getById(anyInt())).thenReturn(mocked);
        Contact byId = contactService.getById(5);
        assertEquals("MockedContact", byId.getFirstName());
    }

    @Test
    public void getAllByUserNameTest() throws Exception {
        List<Contact> allByUserName = new ArrayList<>();

        User mockedUser = new User();
        mockedUser.setUsername("mockedUser");

        Contact mockedContact1 = new Contact();
        mockedContact1.setUser(mockedUser);

        Contact mockedContact2 = new Contact();
        mockedContact2.setUser(mockedUser);

        allByUserName.add(mockedContact1);
        allByUserName.add(mockedContact2);

        when(contactService.getAllByUserName(anyString())).thenReturn(allByUserName);
        List<Contact> result = contactService.getAllByUserName("mockedUser");
        verify(contactService).getAllByUserName("mockedUser");


    }
}
