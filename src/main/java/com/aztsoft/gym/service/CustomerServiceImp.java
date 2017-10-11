package com.aztsoft.gym.service;

import com.aztsoft.gym.domain.CustomerRegistration;
import com.aztsoft.gym.persistence.dao.CustomerDao;
import com.aztsoft.gym.persistence.dao.CustomerDaoImp;
import com.aztsoft.gym.view.forms.form.CustomerForm;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import javax.swing.*;

/**
 * Created by arnold9108@gmail.com
 */
public class CustomerServiceImp implements CustomerService{
    private final CustomerDao customerDao;
    private CustomerForm view;

    public CustomerServiceImp() {
        customerDao = new CustomerDaoImp();
    }
    
    public CustomerServiceImp(CustomerForm view) {
        customerDao = new CustomerDaoImp();
        this.view = view;
    }

    
    @Override
    public final void postCustomer(CustomerRegistration registry) {
        if(StringUtils.isBlank(registry.getCustomer().getName())
                || StringUtils.isBlank(registry.getPlan())
                || registry.getCost() <= 0) {
            view.showMessage("NO SE HAN LLENADO CAMPOS OBLIGATORIOS", "ERROR DE VALIDACION", JOptionPane.ERROR_MESSAGE);
            view.showFieldRequiredName();
            return;
        }
        customerDao.postCustomer(registry);
        view.showMessage("EL CLIENTE SE HA AGREGADO CON EXITO!", "CLIENTE AÑADIDO", JOptionPane.PLAIN_MESSAGE);
        view.cleanFields();
        view.hideFieldRequiredName();
    }

    @Override
    public final List<CustomerRegistration> getAllCustomerRecords() {
        return customerDao.getAllCustomerRecords();
    }

}
