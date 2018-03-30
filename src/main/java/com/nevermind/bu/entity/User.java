package com.nevermind.bu.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Pattern(regexp = "[a-zA-Z]+", message = "Username must have only English characters, " +
            "without special characters")
    @Size(min = 3, message = "Username size must be more then 3")
    @Column(unique = true)
    private String userName;

    @Size(min = 5, message = "Password size must be more then 5")
    private String password;

    @Size(min = 5, message = "Name size must be more then 5")
    @NotNull(message = "Name must be not null")
    private String name;

    @Size(min = 5, message = "Last name size must be more then 5")
    @NotNull(message = "Last name must be not null")
    private String lastName;

    @Size(min = 5, message = "Middle name size must be more then 5")
    @NotNull(message = "Middle name must be not null")
    private String middleName;

    public User() {
    }
}
