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
    public Contact getById(int id, int userId) {
        return contactDao.findAllByUserId(userId).stream().filter(contact -> contact.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public List<Contact> getAll(int userId) {
        List<Contact> allContacts = contactDao.findAllByUserId(userId);
        User user = userDao.findById(userId);
        allContacts.forEach(contact -> contact.setUser(user));
        return allContacts;
    }

    @Override
    public Contact save(Contact contact, int userId) {
        contact.setUser(userDao.findById(userId));
        return contactDao.save(contact);
    }

    @Override
    public void delete(int id, int userId) {
        Contact found = contactDao.findAllByUserId(userId).stream().filter(contact -> contact.getId() == id)
                .findFirst().orElse(null);
        contactDao.delete(found);
    }

    @Override
    public Contact update(Contact contact) {
        return contactDao.save(contact);
    }

    @Override
    public List<Contact> getByName(String name, int userId) {
        List<Contact> contactList = contactDao.findAllByUserId(userId);
        return contactList.stream().filter(contact -> contact.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<Contact> getByLastName(String lastName, int userId) {
        List<Contact> contactList = contactDao.findAllByUserId(userId);
        return contactList.stream()
                .filter(contact -> contact.getLastName().equals(lastName)).collect(Collectors.toList());
    }

    @Override
    public List<Contact> getByMobilePhone(String mobilePhone, int userId) {
        List<Contact> contactList = contactDao.findAllByUserId(userId);
        return contactList.stream()
                .filter(contact -> contact.getMobilePhoneNumber().equals(mobilePhone)).collect(Collectors.toList());
    }
}
