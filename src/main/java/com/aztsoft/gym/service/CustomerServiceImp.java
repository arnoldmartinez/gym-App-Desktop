package com.aztsoft.gym.service;

import com.aztsoft.gym.domain.CustomerRegistration;
import com.aztsoft.gym.persistence.dao.CustomerDao;
import com.aztsoft.gym.persistence.dao.CustomerDaoImp;
import com.aztsoft.gym.view.CustomerForm;
import java.util.List;

import com.aztsoft.gym.view.ViewForm;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;

/**
 * Created by arnold9108@gmail.com
 */
public class CustomerServiceImp implements CustomerService{
    private final CustomerDao customerDao;
    private CustomerForm customerForm;

    public CustomerServiceImp() {
        customerDao = new CustomerDaoImp();
    }

    public CustomerServiceImp(ViewForm customerView) {
        setView(customerView);
        customerDao = new CustomerDaoImp();
    }

    private void setView(ViewForm view){
        if(view instanceof CustomerForm) {
            this.customerForm = (CustomerForm) view;
        }
    }

    @Override
    public final void postCustomer(CustomerRegistration registry) {
        if(StringUtils.isBlank(registry.getCustomer().getName())
                || StringUtils.isBlank(registry.getPlan())
                || registry.getCost() <= 0) {
            customerForm.showMessage("NO SE HAN LLENADO CAMPOS OBLIGATORIOS", "ERROR DE VALIDACION", JOptionPane.ERROR_MESSAGE);
            customerForm.showFieldRequiredName();
            return;
        }
        customerDao.postCustomer(registry);
        customerForm.showMessage("EL CLIENTE SE HA AGREGADO CON EXITO!", "CLIENTE AÑADIDO", JOptionPane.PLAIN_MESSAGE);
        customerForm.cleanFields();
        customerForm.hideFieldRequiredName();
    }

    @Override
    public final List<CustomerRegistration> getAllCustomerRecords() {
        return customerDao.getAllCustomerRecords();
    }

}
