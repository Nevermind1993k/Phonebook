package com.nevermind.bu.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private String lastName;

    @Column
    private String middleName;

    public User() {
    }
}
