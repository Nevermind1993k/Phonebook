package com.nevermind.bu.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    @Size(min = 3, message = "Username size must be more then 3")
    @Pattern(regexp = "[a-zA-Z]+", message = "Username must have only English characters, " +
            "without special characters")
    private String username;

    @Column(nullable = false)
    @Size(min = 5, message = "Password size must be more then 5")
    private String password;

    @Column(unique = true, nullable = false)
    @Size(min = 5, message = "Name size must be more then 5")
    @NotNull(message = "Name must be not null")
    private String firstName;

    @Column(nullable = false)
    @Size(min = 5, message = "Last name size must be more then 5")
    @NotNull(message = "Last name must be not null")
    private String lastName;

    @Column(nullable = false)
    @Size(min = 5, message = "Middle name size must be more then 5")
    @NotNull(message = "Middle name must be not null")
    private String middleName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Contact> contacts;

}
