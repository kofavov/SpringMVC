package com.webapp6.dao;

import com.webapp6.models.Employee;

import java.util.List;

public interface EmplDAO {
    List<Employee> getEmployees();
    Employee getOneById(int id);
    void add(Employee employee);
}
