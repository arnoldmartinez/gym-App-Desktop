package com.aztsoft.gym.persistence.dao.transaction;

import com.aztsoft.gym.domain.Customer;
import com.aztsoft.gym.domain.CustomerRegistration;
import com.aztsoft.gym.persistence.connection.ConnectionJDBC;
import com.aztsoft.gym.persistence.dao.transaction.exception.TransactionException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arnold9108@gmail.com on 29/09/2017.
 */
@SuppressWarnings("DefaultFileTemplate")
public class CustomerTransaction {

    private static final String INSERT_CUSTOMER_QUERY = "INSERT INTO CUSTOMER(ID, NAME, AGE, ADDRESS, IMAGE) VALUES(?,?,?,?,?)";
    private static final String INSERT_CUSTOMER_REGISTRATION_QUERY = "INSERT INTO CUSTOMER_REGISTRATION(ID_CUSTOMER, PLAN, REGISTRATION_DATE, REGISTRATION_LIMIT, COST) VALUES(?,?,?,?,?)";
    private static final String GET_ALL_CUSTOMER_RECORDS_QUERY = "select c.NAME, c.AGE, c.ADDRESS, cr.PLAN, cr.REGISTRATION_DATE, cr.REGISTRATION_LIMIT \n" +
            "from customer c, customer_registration cr\n" +
            "where c.ID = cr.ID_CUSTOMER\n" +
            "order by cr.REGISTRATION_DATE desc;";
    private static final int ROW_AFFECTED = 1;
    private final Connection connection;
    private PreparedStatement customerStatement;
    private ResultSet resultCustomer;

    public CustomerTransaction(ConnectionJDBC connectionJDBC) {
        this.connection = connectionJDBC.getConnection();
    }

    public final void insertCustomer(CustomerRegistration registry) throws TransactionException {
        try {
            tryInsertCustomerDateBase(registry);
        } catch (SQLException | IOException exception) {
            throwCustomerTransactionException(exception.getMessage(), exception.getCause());
        }
    }

    private void tryInsertCustomerDateBase(CustomerRegistration registry) throws SQLException, IOException {
        connection.setAutoCommit(false);
        customerStatement = connection.prepareStatement(INSERT_CUSTOMER_QUERY);
        customerStatement.setString(CustomerTableDB.ID_CUSTOMER_FIELD, registry.getCustomer().getId());
        customerStatement.setString(CustomerTableDB.NAME_FIELD, registry.getCustomer().getName());
        customerStatement.setInt(CustomerTableDB.AGE_FIELD, registry.getCustomer().getAge());
        customerStatement.setString(CustomerTableDB.ADDRESS_FIELD, registry.getCustomer().getAddress());
        if (registry.getCustomer().getPhoto() != null) {
            customerStatement.setBinaryStream(CustomerTableDB.PHOTO_FIELD, registry.getCustomer().getPhoto(), registry.getCustomer().getPhoto().available());
        } else {
            customerStatement.setBinaryStream(CustomerTableDB.PHOTO_FIELD, null);
        }
        PreparedStatement registryStatement = connection.prepareStatement(INSERT_CUSTOMER_REGISTRATION_QUERY);
        registryStatement.setString(CustomerTableDB.ID_CUSTOMER_FIELD, registry.getCustomer().getId());
        registryStatement.setString(CustomerRegistrationTableDB.PLAN_FIELD, registry.getPlan());
        registryStatement.setString(CustomerRegistrationTableDB.REGISTRATION_DATE_FIELD, registry.getRegistrationDate());
        registryStatement.setString(CustomerRegistrationTableDB.REGISTRATION_LIMIT_FIELD, registry.getRegistrationLimit());
        registryStatement.setDouble(CustomerRegistrationTableDB.COST_FIELD, registry.getCost());
        int customerRegistryAffected = customerStatement.executeUpdate();
        int registryRowAffected = registryStatement.executeUpdate();
        if(customerRegistryAffected == ROW_AFFECTED & registryRowAffected  == ROW_AFFECTED) {
            connection.commit();
        }
        customerStatement.close();
        registryStatement.close();
    }

    public final List<CustomerRegistration> getAllCustomerRecords() throws TransactionException {
        try {
            return tryGetAllCustomerRecords();
        } catch (SQLException sqlException) {
            throwCustomerTransactionException(sqlException.getMessage(), sqlException.getCause());
        } finally {
            try {
                resultCustomer.close();
            } catch (SQLException sqlException) {
                throwCustomerTransactionException(sqlException.getMessage(), sqlException.getCause());
            }
        }
        return null;
    }

    private List<CustomerRegistration> tryGetAllCustomerRecords() throws SQLException {
        List<CustomerRegistration> registry = new ArrayList<>();
        connection.setAutoCommit(false);
        customerStatement = connection.prepareStatement(GET_ALL_CUSTOMER_RECORDS_QUERY);
        resultCustomer = customerStatement.executeQuery();
        while(resultCustomer.next()) {
            CustomerRegistration customerRegistration = new CustomerRegistration();
            Customer customer = new Customer();
            customerRegistration.setCustomer(customer);
            customerRegistration.getCustomer().setName(resultCustomer.getString(CustomerTableDB.NAME_CELL_ROW));
            customerRegistration.getCustomer().setAge(resultCustomer.getInt(CustomerTableDB.AGE_CELL_ROW));
            customerRegistration.getCustomer().setAddress(resultCustomer.getString(CustomerTableDB.ADDRESS_CELL_ROW));
            customerRegistration.setPlan(resultCustomer.getString(CustomerRegistrationTableDB.PLAN_CELL_ROW));
            customerRegistration.setRegistrationDate(resultCustomer.getString(CustomerRegistrationTableDB.REGISTRATION_DATE_CELL_ROW));
            customerRegistration.setRegistrationLimit(resultCustomer.getString(CustomerRegistrationTableDB.REGISTRATION_LIMIT_CELL_ROW));
            registry.add(customerRegistration);
        }
        customerStatement.close();
        return registry;
    }

    private void throwCustomerTransactionException(String message, Throwable cause) throws TransactionException {
        throw new TransactionException(message, cause);
    }

}
