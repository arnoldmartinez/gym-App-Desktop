package com.aztsoft.gym.service;

import com.aztsoft.gym.domain.CustomerRegistration;
import com.aztsoft.gym.persistence.dao.CustomerDao;
import com.aztsoft.gym.persistence.dao.CustomerDaoImp;
import com.aztsoft.gym.view.CustomerForm;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;

/**
 * Created by arnold9108@gmail.com
 */
public class CustomerServiceImp implements  CustomerService{

    private CustomerDao customerDao;
    private CustomerForm customerView;

    public CustomerServiceImp(CustomerForm customerView) {
        setCustomerView(customerView);
        customerDao = new CustomerDaoImp();
    }
    
    @Override
    public void postCustomer(CustomerRegistration registry) {
        if(StringUtils.isBlank(registry.getCustomer().getName()) 
                || StringUtils.isBlank(registry.getPlan())
                || registry.getCost() <= 0) {
            getCustomerView().showMessage("NO SE HAN LLENADO CAMPOS OBLIGATORIOS", "ERROR DE VALIDACION", JOptionPane.ERROR_MESSAGE);
            getCustomerView().showFieldRequiredName();
            return;
        }
        customerDao.postCustomer(registry);
        getCustomerView().showMessage("CLIENTE AGREGADO CON EXITO!", "EXITOSAMENTE!", JOptionPane.PLAIN_MESSAGE);
        getCustomerView().hideFieldRequiredName();
        getCustomerView().cleanFields();
        getCustomerView().hideFieldRequiredName();
    }

    @Override
    public List<CustomerRegistration> getAllCustomerRecords() {
        return customerDao.getAllCustomerRecords();
    }
    
    private CustomerForm getCustomerView() {
        return customerView;
    }

    private void setCustomerView(CustomerForm customerView) {
        this.customerView = customerView;
    }
    
}
