package com.aztsoft.gym.service;

import com.aztsoft.gym.domain.Customer;
import com.aztsoft.gym.domain.CustomerRegistration;
import java.util.List;

/**
 * Created by arnold9108@gmail.com on 5/09/17.
 */
public interface CustomerService {

    void postCustomer(CustomerRegistration registry);
    
    List<CustomerRegistration> getAllCustomerRecords();
}
