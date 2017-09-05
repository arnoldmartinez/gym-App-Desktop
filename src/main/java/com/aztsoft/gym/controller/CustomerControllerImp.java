/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztsoft.gym.controller;

import com.aztsoft.gym.persistence.connection.ConnectionMySQL;
import com.aztsoft.gym.persistence.dao.CustomerDao;
import com.aztsoft.gym.persistence.dao.CustomerDaoImp;
import com.aztsoft.gym.domain.Customer;
import com.aztsoft.gym.domain.CustomerRegistration;
import com.aztsoft.gym.service.CustomerService;
import com.aztsoft.gym.service.CustomerServiceImp;
import com.aztsoft.gym.view.CustomerForm;


/**
 *
 * @author arnold9108@gmail.com
 */
public class CustomerControllerImp implements CustomerController {

    private CustomerService customerService;
    private final CustomerForm customerView;

    public CustomerControllerImp(CustomerForm customerView) {
        this.customerView = customerView;
        customerService = new CustomerServiceImp(customerView);
        startView();
    }

    private void startView() {
        customerView.startView();
    }

    @Override
    public void postCustomer() {
        customerService.postCustomer(getRegistry());
        customerView.cleanFields();
    }

    private CustomerRegistration getRegistry() {
        CustomerRegistration aRegistry = new CustomerRegistration();
        aRegistry.setCustomer(getDataClient());
        aRegistry.setRegistrationDate(customerView.lblDate.getText());
        return aRegistry;
    }

    private Customer getDataClient() {

        Customer client = new Customer();
        client.setName(customerView.txtName.getText());
        client.setAge(getAgeClient());
        client.setAddress(customerView.txaAddress.getText());
        client.setPlan((String) customerView.cmbPlan.getSelectedItem());
        client.setPhoto(customerView.imageBlob);

        return client;
    }

    private int getAgeClient() {
        return new Integer(customerView.txtAge.getText());
    }

}
