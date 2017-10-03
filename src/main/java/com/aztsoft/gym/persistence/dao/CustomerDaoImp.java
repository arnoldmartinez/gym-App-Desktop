/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztsoft.gym.persistence.dao;

import com.aztsoft.gym.domain.CustomerRegistration;
import com.aztsoft.gym.persistence.connection.ConnectionMySQL;
import com.aztsoft.gym.persistence.dao.transaction.exception.TransactionException;
import com.aztsoft.gym.persistence.dao.transaction.CustomerTransaction;

import java.util.List;

/**
 * @author arnold9108@gmail.com
 */
public class CustomerDaoImp implements CustomerDao {

    @Override
    public void postCustomer(CustomerRegistration registry) {
        CustomerTransaction customerTransaction = new CustomerTransaction(new ConnectionMySQL());
        try {
            customerTransaction.insertCustomer(registry);
        } catch (TransactionException transactionException) {
            transactionException.printStackTrace();
        }
    }

    @Override
    public List<CustomerRegistration> getAllCustomerRecords() {
        CustomerTransaction customerTransaction = new CustomerTransaction(new ConnectionMySQL());
        try {
            return customerTransaction.getAllCustomerRecords();
        } catch (TransactionException transactionException) {
            transactionException.printStackTrace();
        }
        return null;
    }

}
