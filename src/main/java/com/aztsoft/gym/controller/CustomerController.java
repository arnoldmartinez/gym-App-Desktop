/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztsoft.gym.controller;

import com.aztsoft.gym.domain.Customer;
import com.aztsoft.gym.domain.CustomerRegistration;

import java.util.List;

/**
 *
 * @author windows
 */
public interface CustomerController {
    
    void postCustomer();
    
    List<CustomerRegistration> getAllCustomerRecords();
}
