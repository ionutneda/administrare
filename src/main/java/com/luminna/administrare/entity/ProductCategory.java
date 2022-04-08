package com.luminna.administrare.entity;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class ProductCategory {

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