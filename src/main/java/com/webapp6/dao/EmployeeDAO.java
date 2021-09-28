package com.webapp6.dao;

import com.webapp6.models.Employee;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Component
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

    public List<Employee> getEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt(1));
            employee.setFio(resultSet.getString(2));
            employee.setCompanyid(resultSet.getInt(3));
            employee.setSalary(resultSet.getInt(4));
            employees.add(employee);
        }
        return employees;
    }

    public Employee getOneById(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from employee where id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt(1));
                employee.setFio(resultSet.getString(2));
                employee.setCompanyid(resultSet.getInt(3));
                employee.setSalary(resultSet.getInt(4));
                return employee;
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public void add(Employee employee) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement
                        ("INSERT into employee values (?,?,?,?)");
        preparedStatement.setInt(1,employee.getId());
        preparedStatement.setString(2,employee.getFio());
        preparedStatement.setInt(3,employee.getCompanyid());
        preparedStatement.setInt(4,employee.getSalary());
        preparedStatement.execute();
    }


}
