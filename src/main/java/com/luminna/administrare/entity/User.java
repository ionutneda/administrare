package com.luminna.administrare.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter @Setter @NoArgsConstructor @ToString @Builder
public class User {
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
    private String firstName;

    @NotBlank(message = "Numele este obligatoriu")
    private String lastName;

    @NotBlank(message = "Emailul este obligatoriu")
    private String email;

    public User(long id, String firstName, String name, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = name;
        this.email = email;
    }

}
