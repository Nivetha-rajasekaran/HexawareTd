package com.examly.service;
import com.examly.entity.*;
import com.examly.exception.*;

public interface CustomerService {
  
    boolean createCustomer(Customer customer) throws EmailAlreadyRegisteredException;
}

