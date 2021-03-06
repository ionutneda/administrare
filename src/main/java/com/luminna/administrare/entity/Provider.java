package com.luminna.administrare.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "provider")
public class Provider {

    @Id
    @SequenceGenerator(
            name = "provider_sequence_generator",
            sequenceName = "provider_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "provider_sequence_generator")
    private Long id;

    @NotBlank(message = "Numele este obligatoriu.")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    private Double discount; //percentage
    private int deliveryTerm;  //weeks
    private String country;


    public Provider(String name, Double discount, int deliveryTerm, String country) {
        this.name = name;
        this.discount = discount;
        this.deliveryTerm = deliveryTerm;
        this.country = country;
    }
}
