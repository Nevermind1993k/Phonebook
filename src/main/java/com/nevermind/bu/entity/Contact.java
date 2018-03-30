package com.nevermind.bu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 4, message = "Name size must be more then 4")
    @NotNull(message = "Name must be not null")
    private String name;

    @Size(min = 4, message = "Last name size must be more then 4")
    @NotNull(message = "Last name must be not null")
    private String lastName;

    @Size(min = 4, message = "Middle name size must be more then 4")
    @NotNull(message = "Middle name must be not null")
    private String middleName;

    @NotNull(message = "Phone number mu be not null")
    private String mobilePhoneNumber;

    private String homePhoneNumber;

    private String address;

    private String email;

    public Contact() {
    }

}
