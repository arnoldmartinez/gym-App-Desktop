/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztsoft.gym.controller;

import com.aztsoft.gym.model.dto.Customer;
import com.aztsoft.gym.view.CustomerForm;

/**
 *
 * @author windows
 */
public interface CustomerController {
    
    void postClient(CustomerForm customerView, Customer customerModel);
}
