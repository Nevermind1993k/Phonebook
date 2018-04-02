package com.nevermind.bu.service.interfaces;

import com.nevermind.bu.entity.Contact;

import java.util.List;

public interface ContactService {

    Contact getById(int id);

    List<Contact> getAll();

    List<Contact> getAllByUserName(String username);

    Contact createNewContact(Contact contact);

    void update(Contact contact);

    void delete(int id);

    void delete(Contact contact);

}
