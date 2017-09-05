/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztsoft.gym.controller;

import com.aztsoft.gym.model.connection.ConnectionMySQL;
import com.aztsoft.gym.model.dao.CustomerDao;
import com.aztsoft.gym.model.dao.CustomerDaoImp;
import com.aztsoft.gym.model.dto.Customer;
import com.aztsoft.gym.model.dto.CustomerRegistration;
import com.aztsoft.gym.model.dto.Modality;
import com.aztsoft.gym.view.CustomerForm;

import java.util.UUID;

/**
 *
 * @author arnold9108@gmail.com
 */
public class CustomerControllerImp implements CustomerController {

    private final CustomerDao customerDao;
    private final CustomerForm customerView;

    public CustomerControllerImp(CustomerForm customerView) {
        this.customerView = customerView;
        customerDao = new CustomerDaoImp(new ConnectionMySQL());
        startView();
    }
    
    private void startView(){
        customerView.startView();
    }
    
    @Override
    public void postCustomer() {
        customerDao.postCustomer(getRegistry());
    }

    private CustomerRegistration getRegistry(){
        CustomerRegistration aRegistry = new CustomerRegistration();
        aRegistry.setCustomer(getDataClient());
        aRegistry.setRegistrationDate(customerView.lblDate.getText());
        return aRegistry;
    }

    private Customer getDataClient() {
            
        Customer client = new Customer();
        client.setId(UUID.randomUUID().toString());
        client.setName(customerView.txtName.getText());
        client.setAge(getAgeClient());
        client.setAddress(customerView.txaAddress.getText());
        assignPlan(client);
        client.setPhoto(customerView.imageBlob);
            
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
