package com.webapp6.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class EmployeeDAO {
    private static Connection connection;

    static {
        String url = null;
        String username = null;
        String password = null;

        try(InputStream inputStream = EmployeeDAO.class.getClassLoader().getResourceAsStream("persistence.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            url = properties.getProperty("url");
            username=properties.getProperty("username");
            password=properties.getProperty("password");
        }catch (IOException ioException){
            ioException.printStackTrace();
        }

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
