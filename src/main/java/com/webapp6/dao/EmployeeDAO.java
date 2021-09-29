package com.webapp6.dao;

import com.webapp6.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//@Component
//public class EmployeeDAO implements EmplDAO {
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public EmployeeDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//    @Override
//    public List<Employee> getEmployees()  {
////        List<Employee> employees = new ArrayList<>();
////
////        PreparedStatement preparedStatement = connection.prepareStatement();
////        ResultSet resultSet = preparedStatement.executeQuery();
////        while (resultSet.next()) {
////            Employee employee = new Employee();
////            employee.setId(resultSet.getInt(1));
////            employee.setFio(resultSet.getString(2));
////            employee.setCompanyid(resultSet.getInt(3));
////            employee.setSalary(resultSet.getInt(4));
////            employees.add(employee);
////        }
//        return jdbcTemplate.query("SELECT * FROM employee",new BeanPropertyRowMapper<>(Employee.class));
//    }
//    @Override
//    public Employee getOneById(int id){
////        try {
////            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from employee where id = ?");
////            preparedStatement.setInt(1,id);
////            ResultSet resultSet = preparedStatement.executeQuery();
////            if (resultSet.next()){
////                Employee employee = new Employee();
////                employee.setId(resultSet.getInt(1));
////                employee.setFio(resultSet.getString(2));
////                employee.setCompanyid(resultSet.getInt(3));
////                employee.setSalary(resultSet.getInt(4));
////                return employee;
////            }
////        } catch (SQLException e) {
////
////        }
//        return jdbcTemplate.query(
//                "SELECT * from employee where id = ?",new Object[]{id},new BeanPropertyRowMapper<>(Employee.class))
//                .stream().findAny().orElse(null);
//    }
//    @Override
//    public void add(Employee employee)  {
////        PreparedStatement preparedStatement =
////                connection.prepareStatement
////                        ("INSERT into employee values (?,?,?,?)");
////        preparedStatement.setInt(1,employee.getId());
////        preparedStatement.setString(2,employee.getFio());
////        preparedStatement.setInt(3,employee.getCompanyid());
////        preparedStatement.setInt(4,employee.getSalary());
////        preparedStatement.execute();
//        jdbcTemplate.update("insert  into employee values (?,?,?,?)",employee.getId(),employee.getFio(),employee.getCompanyid(),employee.getSalary());
//    }
//
//
//}
