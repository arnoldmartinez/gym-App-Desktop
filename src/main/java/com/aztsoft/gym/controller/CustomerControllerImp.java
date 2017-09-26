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
import com.aztsoft.gym.view.CustomerCatalogForm;
import com.aztsoft.gym.view.CustomerForm;
import com.aztsoft.gym.view.ViewForm;
import com.toedter.calendar.JDateChooser;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author arnold9108@gmail.com 11/09/2017
 */
public class CustomerControllerImp implements CustomerController {

    private static final int VISIT = 0;
    private CustomerForm customerForm;
    private CustomerCatalogForm customerCatalogForm;
    
    public CustomerControllerImp(ViewForm view) {
        setView(view);
        startView(view);
    }

    private void setView(ViewForm view){
        
        if(view instanceof CustomerForm) this.customerForm = (CustomerForm) view;
        if(view instanceof CustomerCatalogForm) this.customerCatalogForm = (CustomerCatalogForm) view;
        
    }

     private void startView(ViewForm view) {
        view.startView();
    }
    
    @Override
    public void postCustomer() {
        CustomerService customerService = new CustomerServiceImp(customerForm);
        customerService.postCustomer(getDataRegistry());
    }

    private CustomerRegistration getDataRegistry() {

        CustomerRegistration aRegistry = new CustomerRegistration();
        aRegistry.setCustomer(getDataClient());
        aRegistry.setPlan((String) customerForm.cmbPlan.getSelectedItem());
        aRegistry.setRegistrationDate(customerForm.lblDate.getText());
        aRegistry.setRegistrationLimit(getFormatDate(customerForm.jdcLimitDate));

        if(customerForm.cmbPlan.getSelectedIndex() > VISIT)
            aRegistry.setRegistrationLimit(getFormatDate(customerForm.jdcLimitDate));

        if(StringUtils.isNotBlank(customerForm.txtCost.getText()))
            aRegistry.setCost(new Double(customerForm.txtCost.getText()));

        return aRegistry;
    }

    private Customer getDataClient() {

        Customer aClient = new Customer();
        aClient.setName(customerForm.txtName.getText());
        aClient.setAge(getAgeClient());
        aClient.setAddress(customerForm.txaAddress.getText());
        aClient.setPhoto(customerForm.imageBlob);

        return aClient;
    }

    private int getAgeClient() {
        return customerForm.txtAge.getText().equals("") ? 0 : new Integer(customerForm.txtAge.getText());
    }

    private String getFormatDate(JDateChooser dateChooser){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return dateChooser == null ? null : format.format(dateChooser.getDate());
    }

    @Override
    public List<CustomerRegistration> getAllCustomerRecords() {
        CustomerService customerService = new CustomerServiceImp(customerForm);
        return customerService.getAllCustomerRecords();
    }

}
