package com.aztsoft.gym.service;

import com.aztsoft.gym.domain.CustomerRegistration;
import com.aztsoft.gym.persistence.connection.ConnectionMySQL;
import com.aztsoft.gym.persistence.dao.CustomerDao;
import com.aztsoft.gym.persistence.dao.CustomerDaoImp;
import com.aztsoft.gym.view.CustomerForm;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;

/**
 * Created by arnold9108@gmail.com
 */
public class CustomerServiceImp implements  CustomerService{

    private final CustomerDao customerDao;
    private CustomerForm customerView;

    public CustomerServiceImp(CustomerForm customerView) {
        setCustomerView(customerView);
        customerDao = new CustomerDaoImp(new ConnectionMySQL(), customerView);
    }

    @Override
    public void postCustomer(CustomerRegistration registry) {
        if(StringUtils.isBlank(registry.getCustomer().getName()) || StringUtils.isBlank(registry.getCustomer().getPlan())){
            getCustomerView().showMessage("NO SE HAN LLENADO CAMPOS OBLIGATORIOS", "ERROR DE VALIDACION", JOptionPane.ERROR_MESSAGE);
            getCustomerView().showFieldRequiredName();
            return;
        }
        customerDao.postCustomer(registry);
        getCustomerView().hideFieldRequiredName();
        getCustomerView().cleanFields();
    }

    private CustomerForm getCustomerView() {
        return customerView;
    }

    private void setCustomerView(CustomerForm customerView) {
        this.customerView = customerView;
    }
}
