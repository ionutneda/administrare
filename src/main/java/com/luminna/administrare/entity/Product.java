package com.luminna.administrare.entity;

import javax.persistence.*;


//TODO
// try to include a builder pattern constructor


@Entity
@Table(name = "products")
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

    @Column(unique = true)
    private String code;
    private String name;
    private Double price;   // need to use Decimal if I want to process it further
    private String currency;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "provider_id",
            referencedColumnName ="providerId")
    private Provider provider; // Here I might only need the provider Id


    public Product(){}

    public Product(String code, String name, Double price, String currency, Provider provider) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.provider = provider;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + Id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", provider=" + provider +
                '}';
    }
}
