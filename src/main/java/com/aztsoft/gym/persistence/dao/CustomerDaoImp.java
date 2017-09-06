/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztsoft.gym.persistence.dao;

import com.aztsoft.gym.persistence.connection.ConnectionJDBC;
import com.aztsoft.gym.domain.CustomerRegistration;
import com.aztsoft.gym.view.CustomerForm;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author arnold9108@gmail.com
 */
public class CustomerDaoImp implements CustomerDao {

    private Connection connection;
    private CustomerForm CustomerView;

    public CustomerDaoImp(ConnectionJDBC connectionJDBC, CustomerForm customerView) {
        setConnection(connectionJDBC.getConnection());
        setCustomerView(customerView);
    }

    @Override
    public void postCustomer(CustomerRegistration registry) {
        PreparedStatement customerStatement = null;
        PreparedStatement registryStatement = null;

        try {

            getConnection().setAutoCommit(false);

            String insertCustomer = "INSERT INTO CUSTOMER(ID, NAME, AGE, ADDRESS, PLAN, IMAGE) VALUES(?,?,?,?,?,?)";
            customerStatement = getConnection().prepareStatement(insertCustomer);

            customerStatement.setString(1, registry.getCustomer().getId());
            customerStatement.setString(2, registry.getCustomer().getName());
            customerStatement.setInt(3, registry.getCustomer().getAge());
            customerStatement.setString(4, registry.getCustomer().getAddress());
            customerStatement.setString(5, registry.getCustomer().getPlan());

            if (registry.getCustomer().getPhoto() != null)
                customerStatement.setBinaryStream(6, registry.getCustomer().getPhoto(), registry.getCustomer().getPhoto().available());
            else
                customerStatement.setBinaryStream(6, null);

            String insertRegistry = "INSERT INTO CUSTOMER_REGISTRATION(REGISTRATION_DATE, ID_CUSTOMER) VALUES(?,?)";
            registryStatement = getConnection().prepareStatement(insertRegistry);

            registryStatement.setString(1, registry.getRegistrationDate());
            registryStatement.setString(2, registry.getCustomer().getId());

            int customerRegitryAffected = customerStatement.executeUpdate();
            int registryRowAffected = registryStatement.executeUpdate();

            if(customerRegitryAffected == 1 & registryRowAffected  == 1) {
                getCustomerView().showMessage("CLIENTE AGREGADO CON EXITO!", "EXITOSAMENTE!", JOptionPane.PLAIN_MESSAGE);
                getCustomerView().hideFieldRequiredName();
            }
            getConnection().commit();

        } catch (SQLException e) {
            e.printStackTrace();
            if (getConnection() != null) {
                try {
                    getConnection().rollback();
                } catch (SQLException e1) {
                    e1.getCause();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (customerStatement != null) {
                try {
                    customerStatement.close();
                } catch (SQLException e) {
                    e.getCause();
                }
            }
            if (registryStatement != null) {
                try {
                    registryStatement.close();
                } catch (SQLException e) {
                    e.getCause();
                }
            }
            try {
                getConnection().setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(CustomerDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Connection getConnection() {
        return connection;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }

    private CustomerForm getCustomerView() {
        return CustomerView;
    }

    private void setCustomerView(CustomerForm customerView) {
        CustomerView = customerView;
    }
}
