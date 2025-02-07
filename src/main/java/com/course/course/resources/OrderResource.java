package com.course.course.resources;

import com.course.course.entities.Order;
import com.course.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private OrderService service;

    @GetMapping
    ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(service.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
