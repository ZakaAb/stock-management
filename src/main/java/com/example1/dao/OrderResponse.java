package com.example1.dao;


import com.example1.model.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {

    private Order order;
    private float totalPrice;

    public OrderResponse(Order order, float totalPrice) {
        this.order = order;
        this.totalPrice = totalPrice;
    }
}
