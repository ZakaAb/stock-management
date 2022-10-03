package com.example1.controller;

import com.example1.dao.OrderRequest;
import com.example1.dao.OrderResponse;
import com.example1.model.Order;
import com.example1.model.Product;
import com.example1.model.User;
import com.example1.repo.OrderRepository;
import com.example1.repo.ProductRepository;
import com.example1.repo.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
        User _user = userRepository.findById(orderRequest.getUserId()).get();

        ArrayList<Product> products = new ArrayList<>();

       /* for (int i = 0; i < orderRequest.getProductIds().size(); i++) {
            Product _product = productRepository.findById(orderRequest.getProductIds().get(i)).get();
            _product.setQuantity(_product.getQuantity() - 1);
            _product = productRepository.save(_product);
            products.add(_product);
        } */

        for (Map.Entry<Long, Integer> entry : orderRequest.getProductMap().entrySet()) {
            Long pId = entry.getKey();
            Integer qty = entry.getValue();
            Product _product = productRepository.findById(pId).get();
            if (_product.getQuantity() - qty >= 0) {
                _product.setQuantity(_product.getQuantity() - qty);
                _product = productRepository.save(_product);
                products.add(_product);
            }

        }

        Order createdOrder = new Order(_user, products);
        createdOrder = orderRepository.save(createdOrder);




        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }
}
