package com.luminna.administrare.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


//TODO
// include a builder pattern constructor


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "product")
public class Product {

    @Id
    // Using Sequence generator because I'm using MYSQL db which doesn't include one, and it's the recommended way.
    @SequenceGenerator(
            name = "product_sequence_generator",
            sequenceName = "product_sequence",
            allocationSize = 1)
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence_generator")
    private Long Id;

    @NotBlank(message = "Codul este obligatoriu.")
    @Column(unique = true)
    private String code;

    @NotBlank(message = "Numele este obligatoriu.")
    @Size(max = 50, message = "Numele este prea lung.")
    private String name;

    @NotBlank(message = "Pretul este obligatoriu.")
    private Long price;   // need to use Decimal if I want to process it further

    @NotBlank(message = "Producatorul este obligatoriu.")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "provider_id",
            referencedColumnName ="providerId")
    private Provider provider; // Here I might only need the provider Id

    @ManyToOne
    // @NotNull(message = "Categoria este obligatorie.") // this might not be the case
    private ProductCategory productCategory;
    
    // Optional TODO
    // private Boolean inStock;
    // private int quantityInStock;
    // private List<String> images;
    // private String dimensions;
    // private int weight;


    public Product(String code, String name, Long price, Provider provider, ProductCategory productCategory) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.provider = provider;
        this.productCategory = productCategory;
    }
}
