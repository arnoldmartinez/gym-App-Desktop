package com.aztsoft.gym.service;

import com.aztsoft.gym.domain.CustomerRegistration;
import com.aztsoft.gym.persistence.connection.ConnectionMySQL;
import com.aztsoft.gym.persistence.dao.CustomerDao;
import com.aztsoft.gym.persistence.dao.CustomerDaoImp;
import com.aztsoft.gym.view.CustomerForm;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import sun.security.ssl.Debug;

/**
 * Created by vmuser on 5/09/17.
 */
public class CustomerServiceImp implements  CustomerService{

    private final CustomerDao customerDao;
    private CustomerForm CustomerView;

    public CustomerServiceImp(CustomerForm customerView) {
        this.CustomerView = customerView;
        customerDao = new CustomerDaoImp(new ConnectionMySQL(), customerView);
    }

    @Override
    public void postCustomer(CustomerRegistration regitry) {
        if(StringUtils.isBlank(regitry.getCustomer().getName()) || StringUtils.isBlank(regitry.getCustomer().getPlan()))
            Debug.println("", "");
        customerDao.postCustomer(regitry);
    }
}
