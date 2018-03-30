package com.nevermind.bu.service;

import com.nevermind.bu.dao.ContactDao;
import com.nevermind.bu.dao.UserDao;
import com.nevermind.bu.entity.Contact;
import com.nevermind.bu.entity.User;
import com.nevermind.bu.service.interfaces.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactDao contactDao;

    @Autowired
    UserDao userDao;

    @Override
    public Contact getById(int id, String userName) {
        return contactDao.findAllByUserName(userName).stream().filter(contact -> contact.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public List<Contact> getAll(String userName) {
        List<Contact> allContacts = contactDao.findAllByUserName(userName);
        User user = userDao.findByUserName(userName);
        allContacts.forEach(contact -> contact.setUser(user));
        return allContacts;
    }

    @Override
    public Contact save(Contact contact, String userName) {
        contact.setUser(userDao.findByUserName(userName));
        return contactDao.save(contact);
    }

    @Override
    public void delete(int id, String userName) {
        contactDao.delete(id);
    }

    @Override
    public Contact update(Contact contact) {
        return contactDao.save(contact);
    }

    @Override
    public List<Contact> getByName(String name, String userName) {
        List<Contact> contactList = contactDao.findAllByUserName(userName);
        return contactList.stream().filter(contact -> contact.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<Contact> getByLastName(String lastName, String userName) {
        List<Contact> contactList = contactDao.findAllByUserName(userName);
        return contactList.stream()
                .filter(contact -> contact.getLastName().equals(lastName)).collect(Collectors.toList());
    }

    @Override
    public List<Contact> getByMobilePhone(String mobilePhone, String userName) {
        List<Contact> contactList = contactDao.findAllByUserName(userName);
        return contactList.stream()
                .filter(contact -> contact.getMobilePhoneNumber().equals(mobilePhone)).collect(Collectors.toList());
    }
}
