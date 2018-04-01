package com.nevermind.bu.dao;

import com.nevermind.bu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findById(int id);

    User findByUsername(String username);
}
