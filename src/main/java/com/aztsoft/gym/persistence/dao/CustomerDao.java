/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztsoft.gym.persistence.dao;

import com.aztsoft.gym.domain.CustomerRegistration;
import java.util.List;

/**
 *
 * @author arnold9108@gmail.com
 */
public interface CustomerDao {
    
    void postCustomer(CustomerRegistration registry);
    
    List<CustomerRegistration> getAllCustomerRecords();
}
