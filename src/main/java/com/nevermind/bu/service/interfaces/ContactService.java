package com.nevermind.bu.service.interfaces;

import com.nevermind.bu.entity.Contact;

import java.util.List;

public interface ContactService {

    Contact getById(int id, int userId);

    List<Contact> getAll(int userId);

    Contact save(Contact contact, int userId);

    void delete(int id, int userId);

    Contact update(Contact contact);

    List<Contact> getByName(String Name, int userId);

    List<Contact> getByLastName(String lastName, int userId);

    List<Contact> getByMobilePhone(String mobilePhone, int userId);
}
