package com.nevermind.bu.service.interfaces;

import com.nevermind.bu.entity.Contact;

import java.util.List;

public interface ContactService {

    Contact getById(int id, String userName);

    List<Contact> getAll(String userName);

    Contact save(Contact contact, String userName);

    void delete(int id, String userName);

    Contact update(Contact contact);

    List<Contact> getByName(String Name, String userName);

    List<Contact> getByLastName(String lastName, String userName);

    List<Contact> getByMobilePhone(String mobilePhone, String userName);
}
