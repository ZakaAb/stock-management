package com.example1.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private float price;

    private int quantity;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        this.quantity = 10;
    }

    public Product() {

    }

    @JsonBackReference
    @ManyToMany(mappedBy = "products")
    private List<Order> orders;
}
