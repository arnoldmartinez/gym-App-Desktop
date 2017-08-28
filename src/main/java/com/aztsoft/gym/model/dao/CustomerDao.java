/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztsoft.gym.model.dao;

import com.aztsoft.gym.model.dto.CustomerRegistration;

/**
 *
 * @author windows
 */
public interface CustomerDao {
    void postCustomer(CustomerRegistration customer);
}
