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
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @author arnold9108@gmail.com
 */
public class CustomerDaoImp implements CustomerDao {

    private final ConnectionMySQL connectionMySQL;

    private Logger logger = Logger.getLogger(CustomerDaoImp.class);

    public CustomerDaoImp() {
        BasicConfigurator.configure();
        connectionMySQL = new ConnectionMySQL();
    }

    @Override
    public final void postCustomer(CustomerRegistration registry) {
        CustomerTransaction customerTransaction = new CustomerTransaction(connectionMySQL);
        try {
            customerTransaction.insertCustomer(registry);
        } catch (TransactionException transactionException) {
            logger.trace(transactionException.getMessage(), transactionException.getCause());
        }
    }

    @Override
    public final List<CustomerRegistration> getAllCustomerRecords() {
        CustomerTransaction customerTransaction = new CustomerTransaction(connectionMySQL);
        try {
            return customerTransaction.getAllCustomerRecords();
        } catch (TransactionException transactionException) {
            logger.trace(transactionException.getMessage(), transactionException.getCause());
            return null;
        }
    }

}
