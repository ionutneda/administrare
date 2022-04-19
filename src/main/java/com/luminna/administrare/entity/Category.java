package com.luminna.administrare.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "category")
public class Category {


    @Id
    // Using Sequence generator because I'm using MYSQL db which doesn't include one, and it's the recommended way.
    @SequenceGenerator(
            name = "category_sequence_generator",
            sequenceName = "category_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence_generator")
    private Long Id;

    @Size(min = 3, message = "Categoria trebuie sa contina minim 3 caractere.")
    private String name;



}
