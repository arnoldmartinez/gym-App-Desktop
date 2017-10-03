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

    private Connection connection;
    private PreparedStatement customerStatement;
    private  PreparedStatement registryStatement;

    public CustomerTransaction(ConnectionJDBC connectionJDBC) {
        setConnection(connectionJDBC.getConnection());
    }

    public void insertCustomer(CustomerRegistration registry) throws TransactionException {
        try {
            tryInsertCustomerDateBase(registry);
        } catch (SQLException | IOException exception) {
            throw new TransactionException(exception.getMessage(), exception.getCause());
        } finally {
            closeIntancesTransaction();
        }
    }

    private void tryInsertCustomerDateBase(CustomerRegistration registry) throws SQLException, IOException {
        getConnection().setAutoCommit(false);

        setCustomerStatement(getConnection().prepareStatement(INSERT_CUSTOMER_QUERY));
        getCustomerStatement().setString(CustomerTableDB.ID_CUSTOMER_FIELD, registry.getCustomer().getId());
        getCustomerStatement().setString(CustomerTableDB.NAME_FIELD, registry.getCustomer().getName());
        getCustomerStatement().setInt(CustomerTableDB.AGE_FIELD, registry.getCustomer().getAge());
        getCustomerStatement().setString(CustomerTableDB.ADDRESS_FIELD, registry.getCustomer().getAddress());

        if (registry.getCustomer().getPhoto() != null)
            getCustomerStatement().setBinaryStream(CustomerTableDB.PHOTO_FIELD, registry.getCustomer().getPhoto(), registry.getCustomer().getPhoto().available());
        else
            getCustomerStatement().setBinaryStream(CustomerTableDB.PHOTO_FIELD, null);

        setRegistryStatement(getConnection().prepareStatement(INSERT_CUSTOMER_REGISTRATION_QUERY));

        getRegistryStatement().setString(CustomerTableDB.ID_CUSTOMER_FIELD, registry.getCustomer().getId());
        getRegistryStatement().setString(CustomerRegistrationTableDB.PLAN_FIELD, registry.getPlan());
        getRegistryStatement().setString(CustomerRegistrationTableDB.REGISTRATION_DATE_FIELD, registry.getRegistrationDate());
        getRegistryStatement().setString(CustomerRegistrationTableDB.REGISTRATION_LIMIT_FIELD, registry.getRegistrationLimit());
        getRegistryStatement().setDouble(CustomerRegistrationTableDB.COST_FIELD, registry.getCost());

        int customerRegistryAffected = customerStatement.executeUpdate();
        int registryRowAffected = registryStatement.executeUpdate();

        if(customerRegistryAffected == ROW_AFFECTED & registryRowAffected  == ROW_AFFECTED) {
            getConnection().commit();
        }
    }

    private void closeIntancesTransaction() throws TransactionException {
        try {
            closeStatementsSQL();
        } catch (SQLException sqlException) {
            throw new TransactionException(sqlException.getMessage(), sqlException.getCause());
        }
    }

    private void closeStatementsSQL() throws SQLException {
        getCustomerStatement().close();
        getRegistryStatement().close();
    }

    public List<CustomerRegistration> getAllCustomerRecords() throws TransactionException{
        List<CustomerRegistration> registry = new ArrayList<>();
        try {
            return tryGetAllCustomerRecords(registry);
        } catch (SQLException sqlException) {
            throw new TransactionException(sqlException.getMessage(), sqlException.getCause());
        }
    }

    private List<CustomerRegistration> tryGetAllCustomerRecords(List<CustomerRegistration> registry) throws SQLException {
        PreparedStatement customerStatement;
        getConnection().setAutoCommit(false);
        customerStatement = getConnection().prepareStatement(GET_ALL_CUSTOMER_RECORDS_QUERY);
        ResultSet result = customerStatement.executeQuery();
        while(result.next()){
            CustomerRegistration customerRegistration = new CustomerRegistration();
            Customer customer = new Customer();
            customerRegistration.setCustomer(customer);
            customerRegistration.getCustomer().setName(result.getString(CustomerTableDB.NAME_CELL_ROW));
            customerRegistration.getCustomer().setAge(result.getInt(CustomerTableDB.AGE_CELL_ROW));
            customerRegistration.getCustomer().setAddress(result.getString(CustomerTableDB.ADDRESS_CELL_ROW));
            customerRegistration.setPlan(result.getString(CustomerRegistrationTableDB.PLAN_CELL_ROW));
            customerRegistration.setRegistrationDate(result.getString(CustomerRegistrationTableDB.REGISTRATION_DATE_CELL_ROW));
            customerRegistration.setRegistrationLimit(result.getString(CustomerRegistrationTableDB.REGISTRATION_LIMIT_CELL_ROW));
            registry.add(customerRegistration);
        }
        return registry;
    }

    private Connection getConnection() {
        return connection;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }


    private PreparedStatement getCustomerStatement() {
        return customerStatement;
    }

    private void setCustomerStatement(PreparedStatement customerStatement) {
        this.customerStatement = customerStatement;
    }


    private void setRegistryStatement(PreparedStatement registryStatement) {
        this.registryStatement = registryStatement;
    }

    private PreparedStatement getRegistryStatement() {
        return registryStatement;
    }
}
