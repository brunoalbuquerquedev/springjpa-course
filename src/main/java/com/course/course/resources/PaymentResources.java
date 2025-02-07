package com.course.course.resources;

import com.course.course.entities.Payment;
import com.course.course.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping(name = "/payments")
public class PaymentResources implements Serializable {

    @Autowired
    private PaymentService service;

    @GetMapping
    ResponseEntity<List<Payment>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Payment> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
