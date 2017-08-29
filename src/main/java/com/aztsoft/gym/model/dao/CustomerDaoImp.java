/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztsoft.gym.model.dao;

import com.aztsoft.gym.model.connection.ConnectionJDBC;
import com.aztsoft.gym.model.connection.ConnectionMySQL;
import com.aztsoft.gym.model.dto.Customer;
import com.aztsoft.gym.model.dto.CustomerRegistration;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author windows
 */
public class CustomerDaoImp implements CustomerDao {

    private ConnectionJDBC connection;

    public CustomerDaoImp(ConnectionJDBC connection) {
        this.connection = connection;
    }

    @Override

    public void postCustomer(CustomerRegistration registry) {
        try {
            Statement statement = connection.getConnection().createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
