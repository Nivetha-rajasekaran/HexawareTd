package com.examly.service;
import com.examly.entity.*;

public interface PaymentService {
    
    boolean processPayment(Payment payment);
    
}
