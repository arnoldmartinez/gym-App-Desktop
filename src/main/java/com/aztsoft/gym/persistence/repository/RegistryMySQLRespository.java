package com.aztsoft.gym.persistence.repository;

import com.aztsoft.gym.domain.Customer;
import com.aztsoft.gym.domain.CustomerRegistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistryMySQLRespository implements Repository<CustomerRegistration> {
    private PreparedStatement statementCustomerRegistry;
    Repository<Customer> customerMySQLRepository;

    public RegistryMySQLRespository() {
        customerMySQLRepository = new CustomerMySQLRepository();
    }

    public void add(CustomerRegistration customerRegistration) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GYM_DEVELOP_DB", "root", "1234");
            connection.setAutoCommit(false);
            customerMySQLRepository.add(customerRegistration.getCustomer());
            statementCustomerRegistry = connection.prepareStatement("INSERT INTO CUSTOMER_REGISTRATION(ID_CUSTOMER, PLAN, REGISTRATION_DATE, REGISTRATION_LIMIT, COST) VALUES(?,?,NOW(),?,?)");
            statementCustomerRegistry.setString(1, customerRegistration.getCustomer().getId());
            statementCustomerRegistry.setString(2, customerRegistration.getPlan());
            statementCustomerRegistry.setString(3, customerRegistration.getRegistrationLimit());
            statementCustomerRegistry.setDouble(4, customerRegistration.getCost());
            if(statementCustomerRegistry.executeUpdate() == 1 && customerMySQLRepository.success()) {
                connection.commit();
            } else {
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                statementCustomerRegistry.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Boolean success() {
        return null;
    }

}

