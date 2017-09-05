package com.aztsoft.gym.persistence.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by arnold9108@gmail.com on 28/08/17.
 */
public class ConnectionMySQL implements ConnectionJDBC {

    @Override
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/GYM_DEVELOP_DB", "root", "1234");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
