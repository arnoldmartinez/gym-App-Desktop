package com.aztsoft.gym.persistence.repository;

import com.aztsoft.gym.domain.Customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerMySQLRepository implements Repository<Customer> {
    private PreparedStatement statementCustomer;
    private Boolean success = Boolean.FALSE;

    @SuppressWarnings("Since15")
    public void add(Customer customer) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GYM_DEVELOP_DB", "root", "1234");
            connection.setAutoCommit(false);
            statementCustomer = connection.prepareStatement("INSERT INTO CUSTOMER(ID, NAME, AGE, ADDRESS, IMAGE) VALUES(?,?,?,?,?)");
            statementCustomer.setString(1, customer.getId());
            statementCustomer.setString(2, customer.getName());
            statementCustomer.setInt(3, customer.getAge());
            statementCustomer.setString(4, customer.getAddress());
            if(customer.getPhoto() !=  null) {
                statementCustomer.setBinaryStream(5, customer.getPhoto(), customer.getPhoto().available());
            }
            statementCustomer.setBinaryStream(5, null);
            if(statementCustomer.executeUpdate() == 1) {
                connection.commit();
                success = Boolean.TRUE;
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                statementCustomer.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Boolean success(){
        return success;
    }
}
