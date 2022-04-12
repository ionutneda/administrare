package com.luminna.administrare.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


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
    private BigDecimal price;

    // this brings the whole provider object / I just need the provider's id
//    @NotBlank(message = "Producatorul este obligatoriu.")
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "provider_id",
//            referencedColumnName ="providerId")
//    private Provider provider;

    // trying to get the provider's id only
    @JoinColumn(name = "provider_id", insertable=false, updatable=false)
    @ManyToOne(targetEntity = Provider.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Provider provider;

    @NotBlank(message = "Producatorul este obligatoriu.")
    @Column(name="provider_id")
    private Long providerId;

    // trying to get the category's id only
    @JoinColumn(name = "product_category_id", insertable=false, updatable=false)
    @ManyToOne(targetEntity = ProductCategory.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ProductCategory productCategory;

    @Column(name="product_category_id")
    private Long categoryId;

    @Transient
    private Boolean inStock;

    private int stock;  //quantity in stock

    @Transient
    private int availableStock;  //quantity available after reservations

    private String image;   // todo -  needs to be a list
    private String dimensions;
    private double weight;


    public Product(String code, String name, BigDecimal price, Long providerId,
                   Long categoryId, int stock, String image, String dimensions, double weight) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.providerId = providerId;
        this.categoryId = categoryId;
        this.stock = stock;
        this.image = image;
        this.dimensions = dimensions;
        this.weight = weight;
    }
}
