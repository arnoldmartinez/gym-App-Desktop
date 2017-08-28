package com.aztsoft.gym.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vmuser on 28/08/17.
 */
public class ConnectionMysql {

    private void loagDriver(){
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();

        } catch (InstantiationException instantiationException) {
            instantiationException.printStackTrace();
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

    }

    public void getConnection(){
        loagDriver();
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","1234");
            Statement statement = connection.createStatement()){
            String query = "";
            statement.execute(query);
        }catch (SQLException sqlException){
        }
    }

}
