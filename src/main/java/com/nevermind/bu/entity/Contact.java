package com.nevermind.bu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Size(min = 4, message = "Name size must be more then 4")
    @NotNull(message = "Name must be not null")
    private String firstName;

    @Column(nullable = false)
    @Size(min = 4, message = "Last name size must be more then 4")
    @NotNull(message = "Last name must be not null")
    private String lastName;

    @Column(nullable = false)
    @Size(min = 4, message = "Middle name size must be more then 4")
    @NotNull(message = "Middle name must be not null")
    private String middleName;

    @Column(nullable = false)
    @Pattern(regexp = "\\+380\\([1-9]{2}\\)[0-9]{7}"
            , message = "Phone number must be in Ukraine International mobile format" +
            "example: +380(66)1234567")
    @NotNull(message = "Phone number mu be not null")
    private String mobilePhoneNumber;

    @Pattern(regexp = "\\+380\\(44\\)[0-9]{7}"
            , message = "Phone number must be in public telephone network of Ukraine format" +
            "example: +380(44)1234567")
    private String homePhoneNumber;

    private String address;

    @Email(regexp = ".+@.+\\..+|^$", message = "Wrong email format" +
            "example: somemail@gmail.com")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

}
