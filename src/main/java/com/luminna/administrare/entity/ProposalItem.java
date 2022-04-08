package com.luminna.administrare.entity;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
public class ProposalItem {

    public Product product;

    @Min(1)
    @Max(1000)
    private int quantity;

    public ProposalItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void addOne(){
        this.quantity += 1;
    }

    public void subtractOne(){
        this.quantity -= 1;
    }
}
