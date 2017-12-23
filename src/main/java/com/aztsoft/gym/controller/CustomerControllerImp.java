/*
 * @classname CustomerControllerImp
 * @version V1
 * @date 11/09/2017
 * @author arnold9108@gmail.com copyright notice
 */
package com.aztsoft.gym.controller;

import com.aztsoft.gym.domain.CustomerRegistration;
import com.aztsoft.gym.persistence.repository.Repository;
import com.aztsoft.gym.service.CustomerService;
import com.aztsoft.gym.service.CustomerServiceImp;
import com.aztsoft.gym.view.forms.form.CustomerCatalogForm;
import com.aztsoft.gym.view.forms.form.CustomerForm;
import com.aztsoft.gym.view.forms.model.CustomerTableModel;
import com.aztsoft.gym.view.forms.abstractview.ViewForm;

import java.util.List;

public final class CustomerControllerImp implements CustomerController {
    private final CustomerService service;

    public CustomerControllerImp(CustomerService service) {
        this.service = service;
    }
    
    @Override
    public final void save(CustomerRegistration registry) {
        service.postCustomer(registry);
    }

    @Override
    public final void getAllCustomerRecords() {
        CustomerService customerService = new CustomerServiceImp(null);
        List<CustomerRegistration> registres = customerService.getAllCustomerRecords();
        CustomerTableModel customerModel = new CustomerTableModel();
        customerModel.addRecordAll(registres);
        //CustomerCatalogView.setModel(customerModel);
    }

}
