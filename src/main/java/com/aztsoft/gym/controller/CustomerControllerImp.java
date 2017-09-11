/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztsoft.gym.controller;

import com.aztsoft.gym.domain.Customer;
import com.aztsoft.gym.domain.CustomerRegistration;
import com.aztsoft.gym.service.CustomerService;
import com.aztsoft.gym.service.CustomerServiceImp;
import com.aztsoft.gym.view.CustomerForm;
import com.toedter.calendar.JDateChooser;

import java.text.SimpleDateFormat;

/**
 *
 * @author arnold9108@gmail.com
 */
public class CustomerControllerImp implements CustomerController {

    private static final int VISIT = 0;
    private final CustomerService customerService;
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
        customerService.postCustomer(getDataRegistry());
    }

    private CustomerRegistration getDataRegistry() {

        CustomerRegistration aRegistry = new CustomerRegistration();
        aRegistry.setCustomer(getDataClient());
        aRegistry.setRegistrationDate(customerView.lblDate.getText());

        if(customerView.cmbPlan.getSelectedIndex() > VISIT)
            aRegistry.setRegistrationLimit(getFormatDate(customerView.jdcLimitDate));

        return aRegistry;
    }

    private Customer getDataClient() {

        Customer aClient = new Customer();
        aClient.setName(customerView.txtName.getText());
        aClient.setAge(getAgeClient());
        aClient.setAddress(customerView.txaAddress.getText());
        aClient.setPlan((String) customerView.cmbPlan.getSelectedItem());
        aClient.setPhoto(customerView.imageBlob);

        return aClient;
    }

    private int getAgeClient() {
        return customerView.txtAge.getText().equals("") ? 0 : new Integer(customerView.txtAge.getText());
    }

    private String getFormatDate(JDateChooser dateChooser){

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return dateChooser == null ? null : format.format(dateChooser.getDate());
    }

}
