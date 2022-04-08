package com.luminna.administrare.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Getter @Setter @NoArgsConstructor @ToString @Builder
public class User{

    @Id
    @SequenceGenerator(
            name = "product_sequence_generator",
            sequenceName = "product_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence_generator")
    private long id;

    @NotBlank(message = "Prenumele este obligatoriu")
    @Size(min = 3, max = 50, message = "Prenumele este prea lung.")
    private String firstName;

    @NotBlank(message = "Numele este obligatoriu")
    @Size(min = 3, max = 50, message = "Numele este prea lung.")
    private String lastName;

    @NotBlank(message = "Emailul este obligatoriu")
    @Email(message = "Email invalid. Incearca din nou.")
    private String email;

    public User(long id, String firstName, String name, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = name;
        this.email = email;
    }

}
