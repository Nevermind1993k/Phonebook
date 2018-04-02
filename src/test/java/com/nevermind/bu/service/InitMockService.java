package com.nevermind.bu.service;

import com.nevermind.bu.dao.ContactDao;
import com.nevermind.bu.dao.UserDao;
import com.nevermind.bu.entity.Contact;
import com.nevermind.bu.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class InitMockService {

    @Mock
    private UserDao userDao;
    @Mock
    private ContactDao contactDao;

    @InjectMocks
    public UserServiceImpl userService;
    @InjectMocks
    public ContactServiceImpl contactService;

    public User mockUser;
    public Contact mockContact1;
    public Contact mockContact2;
    private Contact updatedContact;
    private List<Contact> contactList;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        mockUser = new User();
        mockUser.setId(1);
        mockUser.setUsername("mockedUser");
        mockUser.setPassword("12345");
        mockUser.setFirstName("mockedName");
        mockUser.setLastName("mockedLastName");
        mockUser.setMiddleName("mockedMiddleName");
        mockUser.setContacts(contactList);

        mockContact1 = new Contact();
        mockContact1.setId(1);
        mockContact1.setFirstName("mockedFirstName");
        mockContact1.setLastName("mockedLastName");
        mockContact1.setMiddleName("MockedMiddleName");
        mockContact1.setMobilePhoneNumber("+380(66)1234567");
        mockContact1.setHomePhoneNumber("+380(44)1234567");
        mockContact1.setAddress("mockedAddress");
        mockContact1.setEmail("mocked@Email.com");
        mockContact1.setUser(mockUser);


        mockContact2 = new Contact();
        mockContact2.setId(2);
        mockContact2.setFirstName("mockedFirstName2");
        mockContact2.setLastName("mockedLastName2");
        mockContact2.setMiddleName("MockedMiddleName2");
        mockContact2.setMobilePhoneNumber("+380(66)7654321");
        mockContact2.setHomePhoneNumber("+380(44)7654321");
        mockContact2.setAddress("mockedAddress2");
        mockContact2.setEmail("mocked2@Email.com");
        mockContact2.setUser(mockUser);

        updatedContact = new Contact();
        updatedContact.setId(mockContact1.getId());
        updatedContact.setFirstName("UpdatedFirstName");
        updatedContact.setLastName("UpdatedLastName");
        updatedContact.setMiddleName("UpdatedMiddleName");
        updatedContact.setMobilePhoneNumber(mockContact1.getMobilePhoneNumber());
        updatedContact.setHomePhoneNumber(mockContact1.getHomePhoneNumber());
        updatedContact.setAddress(mockContact1.getAddress());
        updatedContact.setEmail(mockContact1.getEmail());
        updatedContact.setUser(mockUser);

        when(userDao.findById(mockUser.getId())).thenReturn(mockUser);
        when(userDao.findByUsername(mockUser.getUsername())).thenReturn(mockUser);
        when(contactDao.findAllByUserUsername(mockUser.getUsername())).thenReturn(Arrays.asList(mockContact1, mockContact2));

        when(userDao.save(mockUser)).thenReturn(mockUser);
        when(contactDao.save(mockContact2)).thenReturn(mockContact2);
    }

    @Test
    public void test() {

    }
}
