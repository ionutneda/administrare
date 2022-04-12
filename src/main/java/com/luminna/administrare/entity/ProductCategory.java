package com.luminna.administrare.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class ProductCategory {


    @Id
    // Using Sequence generator because I'm using MYSQL db which doesn't include one, and it's the recommended way.
    @SequenceGenerator(
            name = "product_sequence_generator",
            sequenceName = "product_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence_generator")
    private Long Id;

    @Size(min = 3, message = "Categoria trebuie sa contina minim 3 caractere.")
    private String name;


    public ProductCategory() {}

    public ProductCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "name='" + name + '\'' +
                '}';
    }


}
