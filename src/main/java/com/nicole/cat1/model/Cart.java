package com.nicole.cat1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {

    @Id
    private Integer productId;

    private Integer quantity;

    public Cart() {
    }

    public Cart( Integer quantity) {
        this.quantity = quantity;
    }

    public Cart(Integer productId, Integer quantity){
        this.productId = productId;
        this.quantity = quantity;

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity(Integer integer) {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
