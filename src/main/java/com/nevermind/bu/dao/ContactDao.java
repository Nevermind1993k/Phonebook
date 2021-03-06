package com.nevermind.bu.dao;

import com.nevermind.bu.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactDao extends JpaRepository<Contact, Integer> {

    Contact findById(int id);

    List<Contact> findAllByUserUsername(String username);

}
