package com.example.sash.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    // Simulate payment processing, always successful
    public boolean processPayment(double amount) {
        System.out.println("Processing payment of RM " + amount);
        
        // Simulate some logic, e.g., communicating with a third-party payment gateway
        // Here we just return true for simplicity.
        return true;
    }
}
