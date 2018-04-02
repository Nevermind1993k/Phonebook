package com.nevermind.bu.service;

import com.nevermind.bu.dao.ContactDao;
import com.nevermind.bu.entity.Contact;
import com.nevermind.bu.service.interfaces.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    @Override
    public Contact getById(int id) {
        return contactDao.findById(id);
    }

    @Override
    public List<Contact> getAll() {
        return contactDao.findAll();
    }

    @Override
    public List<Contact> getAllByUserName(String username) {
        return contactDao.findAllByUserUsername(username);
    }

    @Override
    public Contact createNewContact(Contact contact) {
        return contactDao.save(contact);
    }

    @Override
    public void update(Contact contact) {
        contactDao.save(contact);
    }

    @Override
    public void delete(int id) {
        contactDao.delete(id);
    }

    @Override
    public void delete(Contact contact) {
        contactDao.delete(contact);
    }
}
