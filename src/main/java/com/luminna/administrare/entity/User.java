package com.luminna.administrare.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@ToString
@Table(name = "user")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence_generator",
            sequenceName = "user_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence_generator")
    private long id;

    @NotBlank(message = "Prenumele este obligatoriu")
    @Size(min = 3, max = 50, message = "Prenumele este prea lung.")
    private String fName;

    @NotBlank(message = "Numele este obligatoriu")
    @Size(min = 3, max = 50, message = "Numele este prea lung.")
    private String lName;

    @NotBlank(message = "Emailul este obligatoriu")
    @Email(message = "Email invalid. Incearca din nou.")
    private String email;

    public User(String fName, String lName, String email) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }
}
