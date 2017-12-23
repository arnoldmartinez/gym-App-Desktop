package com.aztsoft.gym.service;

import com.aztsoft.gym.domain.CustomerRegistration;
import com.aztsoft.gym.persistence.dao.CustomerDao;
import com.aztsoft.gym.persistence.dao.CustomerDaoImp;
import com.aztsoft.gym.persistence.repository.Repository;
import com.aztsoft.gym.view.forms.form.CustomerForm;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import javax.swing.*;

/**
 * Created by arnold9108@gmail.com
 */
public class CustomerServiceImp implements CustomerService{
    private Repository<CustomerRegistration> respository;

    public CustomerServiceImp(Repository<CustomerRegistration> respository) {
        this.respository = respository;
    }

    @Override
    public final void postCustomer(CustomerRegistration registry) {
        respository.add(registry);
    }

    @Override
    public final List<CustomerRegistration> getAllCustomerRecords() {
        return null;
    }

}
