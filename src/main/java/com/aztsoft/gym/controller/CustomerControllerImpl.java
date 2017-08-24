/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztsoft.gym.controller;

import com.aztsoft.gym.model.dto.Customer;
import com.aztsoft.gym.model.dto.Modality;
import com.aztsoft.gym.view.CustomerForm;

/**
 *
 * @author windows
 */
public class CustomerControllerImpl implements CustomerController {

    private final CustomerForm customerView;

    public CustomerControllerImpl(CustomerForm customerView) {
        this.customerView = customerView;
    }
    
    @Override
    public void postClient() {
        
    }
    
    private Customer getDataClient() {
            
        Customer client = new Customer();
        client.setName(customerView.txtName.getText());
        client.setSurnames(customerView.txtSurnames.getText());
        client.setAge(getAgeClient());
        client.setAddress(customerView.txaAddress.getText());
        assignPlan(client);
            
        return client;
    }
    
    private int getAgeClient() {
        return new Integer(customerView.txtAge.getText());
    }
    
    private void assignPlan(Customer customer) {
            
        if(customerView.radVisit.isSelected()) {
            customer.assignPlan(Modality.VISIT);
        }
        if(customerView.radWeekly.isSelected()) {
            customer.assignPlan(Modality.WEEKLE);
        }
        if(customerView.radBiweekly.isSelected()) {
            customer.assignPlan(Modality.BIWEEKLE);
        }
        if(customerView.radMonthly.isSelected()) {
            customer.assignPlan(Modality.ANNUAL);
        }
        
    }
    
}
