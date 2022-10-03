package com.example1.model;


import com.example1.model.Product;
import com.example1.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Product> products;

    private float totalPrice;

    private Date createdAt;

    public Order(User user, List<Product> products) {
        this.user = user;
        this.products = products;
        float totalPrice = 0;
        for (Product p: products) {
            totalPrice += p.getPrice();
        }
        this.totalPrice = totalPrice;
        this.createdAt = new Date();

    }
}
