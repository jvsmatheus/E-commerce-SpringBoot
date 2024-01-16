package br.com.matheus.naturaSSP.controllers;

import br.com.matheus.naturaSSP.models.Order;
import br.com.matheus.naturaSSP.services.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private IOrderService service;

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        order = service.createOrder(order);
        if (order != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(order);
        }
        return ResponseEntity.badRequest().build();
    }
}
