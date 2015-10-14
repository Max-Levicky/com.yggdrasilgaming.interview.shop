package com.yggdrasilgaming.interview.shop.model;

import javax.persistence.*;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;

    private int quantity;
    @OneToOne
    private Product product;

    public OrderItem() {
    }

    public OrderItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
