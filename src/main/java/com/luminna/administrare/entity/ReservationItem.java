package com.luminna.administrare.entity;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
public class ReservationItem {

    public Product product;

    @Min(1)
    @Max(100)
    private int quantity;

    public ReservationItem(Product product, int quantity) {

        this.product = product;

        // @NotNull   // not allowed here
        // @Positive(message = "Cantitatea trebuie sa fie mai mare decat 0.")  //not allowed here
        this.quantity = quantity;
    }

    public void addOne(){
        this.quantity += 1;
    }

    public void subtractOne(){
        this.quantity -= 1;
    }
}
