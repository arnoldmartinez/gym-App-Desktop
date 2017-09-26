/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztsoft.gym.persistence.dao;

import com.aztsoft.gym.domain.Customer;
import com.aztsoft.gym.persistence.connection.ConnectionJDBC;
import com.aztsoft.gym.domain.CustomerRegistration;
import com.aztsoft.gym.view.CustomerForm;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

            String insertCustomer = "INSERT INTO CUSTOMER(ID, NAME, AGE, ADDRESS, IMAGE) VALUES(?,?,?,?,?)";
            customerStatement = getConnection().prepareStatement(insertCustomer);

            customerStatement.setString(1, registry.getCustomer().getId());
            customerStatement.setString(2, registry.getCustomer().getName());
            customerStatement.setInt(3, registry.getCustomer().getAge());
            customerStatement.setString(4, registry.getCustomer().getAddress());

            if (registry.getCustomer().getPhoto() != null)
                customerStatement.setBinaryStream(5, registry.getCustomer().getPhoto(), registry.getCustomer().getPhoto().available());
            else
                customerStatement.setBinaryStream(5, null);

            String insertRegistry = "INSERT INTO CUSTOMER_REGISTRATION(ID_CUSTOMER, PLAN, REGISTRATION_DATE, REGISTRATION_LIMIT, COST) VALUES(?,?,?,?,?)";
            registryStatement = getConnection().prepareStatement(insertRegistry);

            registryStatement.setString(1, registry.getCustomer().getId());
            registryStatement.setString(2, registry.getPlan());
            registryStatement.setString(3, registry.getRegistrationDate());
            registryStatement.setString(4, registry.getRegistrationLimit());
            registryStatement.setDouble(5, registry.getCost());

            int customerRegistryAffected = customerStatement.executeUpdate();
            int registryRowAffected = registryStatement.executeUpdate();

            if(customerRegistryAffected == 1 & registryRowAffected  == 1) {
                getCustomerView().showMessage("CLIENTE AGREGADO CON EXITO!", "EXITOSAMENTE!", JOptionPane.PLAIN_MESSAGE);
                getCustomerView().hideFieldRequiredName();
                getCustomerView().cleanFields();
            }
            getConnection().commit();

        } catch (SQLException e) {
            e.printStackTrace();
            if (getConnection() != null) {
                rollbackOperation();
                getCustomerView().cleanFields();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(customerStatement);
            closePrepareStatement(registryStatement);
            setAutoCommit();
        }
    }

    private void closePrepareStatement(PreparedStatement preparedStatement){
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.getCause();
            }
        }
    }

    private void setAutoCommit(){
        try {
            getConnection().setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void rollbackOperation(){
        try {
            getConnection().rollback();
        } catch (SQLException e1) {
            e1.getCause();
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

    @Override
    public List<CustomerRegistration> getAllCustomerRecords() {
        PreparedStatement customerStatement = null;
        List<CustomerRegistration> registry = new ArrayList<CustomerRegistration>();
        try {
            getConnection().setAutoCommit(false);
            String selectCustomer = "select c.NAME, c.AGE, c.ADDRESS, cr.PLAN, cr.REGISTRATION_DATE, cr.REGISTRATION_LIMIT \n" +
                    "from customer c, customer_registration cr\n" +
                    "where c.ID = cr.ID_CUSTOMER\n" +
                    "order by cr.REGISTRATION_DATE desc;";
            customerStatement = getConnection().prepareStatement(selectCustomer);
            ResultSet result = customerStatement.executeQuery();
            while(result.next()){
                CustomerRegistration customerRegistration = new CustomerRegistration();
                Customer customer = new Customer();
                customerRegistration.setCustomer(customer);
                customerRegistration.getCustomer().setName(result.getString("NAME"));
                customerRegistration.getCustomer().setAge(result.getInt("AGE"));
                customerRegistration.setPlan(result.getString("PLAN"));
                customerRegistration.setRegistrationDate(result.getString("REGISTRATION_DATE"));
                customerRegistration.setRegistrationLimit(result.getString("REGISTRATION_LIMIT"));
                registry.add(customerRegistration);
            }
            return registry;
        } catch (SQLException e) {
            return null;
        }
    }

}
