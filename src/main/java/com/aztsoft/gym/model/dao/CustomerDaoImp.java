/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztsoft.gym.model.dao;

import com.aztsoft.gym.model.connection.ConnectionJDBC;
import com.aztsoft.gym.model.dto.CustomerRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author arnold9108@gmail.com
 */
public class CustomerDaoImp implements CustomerDao {

    private Connection connection;

    public CustomerDaoImp(ConnectionJDBC connectionJDBC) {
        setConnection(connectionJDBC.getConnection());
    }

    @Override
    public void postCustomer(CustomerRegistration registry) {
        PreparedStatement customerStatement = null;
        PreparedStatement registryStatement = null;

        try {

            getConnection().setAutoCommit(false);

            String insertCustomer = "INSERT INTO CUSTOMER(ID, NAME, AGE, ADDRESS, PLAN) VALUES(?,?,?,?,?)";
            customerStatement = getConnection().prepareStatement(insertCustomer);

            customerStatement.setString(1, registry.getCustomer().getId());
            customerStatement.setString(2, registry.getCustomer().getName());
            customerStatement.setInt(3, registry.getCustomer().getAge());
            customerStatement.setString(4, registry.getCustomer().getAddress());
            customerStatement.setInt(5, registry.getCustomer().getPlan());

            customerStatement.execute();

            String insertRegistry = "INSERT INTO CUSTOMER_REGISTRATION(REGISTRATION_DATE, ID_CUSTOMER) VALUES(?,?)";
            registryStatement = getConnection().prepareStatement(insertRegistry);

            registryStatement.setString(1, registry.getRegistrationDate());
            registryStatement.setString(2, registry.getCustomer().getId());

            registryStatement.execute();

            getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if(getConnection() != null) {
                try {
                    getConnection().rollback();
                } catch (SQLException e1) {
                    e1.getCause();
                }
            }
        } finally {
            if (customerStatement != null) {
                try {
                    customerStatement.close();
                } catch (SQLException e) {
                    e.getCause();
                }
            }
            if(registryStatement != null){
                try {
                    registryStatement.close();
                } catch (SQLException e) {
                    e.getCause();
                }
            }
        }
    }

    private Connection getConnection() {
        return connection;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }
}
