package com.luminna.administrare.entity;

import javax.persistence.*;

@Entity
@Table(name = "providers")
public class Provider {

    @Id
    // Using Sequence generator because I'm using MYSQL db which doesn't include one, and it's the recommended way.
    @SequenceGenerator(
            name = "provider_sequence_generator",
            sequenceName = "provider_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "provider_sequence_generator")
    private Long providerId;

    @Column(unique = true)
    private String name;
    private Double discount; //percentage
    private int deliveryTerm;  //weeks
    private String country;


    public Provider(){}

    public Provider(String name, Double discount, int deliveryTerm, String country) {
        this.name = name;
        this.discount = discount;
        this.deliveryTerm = deliveryTerm;
        this.country = country;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public int getDeliveryTerm() {
        return deliveryTerm;
    }

    public void setDeliveryTerm(int deliveryTerm) {
        this.deliveryTerm = deliveryTerm;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return "Provider{" +
                "providerId=" + providerId +
                ", name='" + name + '\'' +
                ", discount=" + discount +
                ", deliveryTerm=" + deliveryTerm +
                ", country='" + country + '\'' +
                '}';
    }
}
