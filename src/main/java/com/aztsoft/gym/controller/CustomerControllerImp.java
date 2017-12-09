/*
 * @classname CustomerControllerImp
 * @version V1
 * @date 11/09/2017
 * @author arnold9108@gmail.com copyright notice
 */
package com.aztsoft.gym.controller;

import com.aztsoft.gym.domain.CustomerRegistration;
import com.aztsoft.gym.service.CustomerService;
import com.aztsoft.gym.service.CustomerServiceImp;
import com.aztsoft.gym.view.forms.form.CustomerCatalogForm;
import com.aztsoft.gym.view.forms.form.CustomerForm;
import com.aztsoft.gym.view.forms.model.CustomerTableModel;
import com.aztsoft.gym.view.forms.abstractview.ViewForm;

import java.util.List;

public class CustomerControllerImp implements CustomerController {
    private CustomerForm customerView;
    private CustomerCatalogForm CustomerCatalogView;

    public CustomerControllerImp() {
    }
    
    public CustomerControllerImp(ViewForm view) {
        setview(view);
    }
    
    private void setview(ViewForm view) {
        if(view instanceof CustomerForm) {
            customerView = (CustomerForm) view;
        }
        if(view instanceof CustomerCatalogForm) {
            this.CustomerCatalogView = (CustomerCatalogForm) view;
        }
    }
    
    @Override
    public final void postCustomer() {
        CustomerService customerService = new CustomerServiceImp(customerView);
        customerService.postCustomer(customerView.getDataRegistry());
    }

    @Override
    public final void getAllCustomerRecords() {
        CustomerService customerService = new CustomerServiceImp();
        List<CustomerRegistration> registres = customerService.getAllCustomerRecords();
        CustomerTableModel customerModel = new CustomerTableModel();
        customerModel.addRecordAll(registres);
        CustomerCatalogView.setModel(customerModel);
    }

}
