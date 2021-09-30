package com.webapp6.service;

import com.webapp6.models.Employee;

import java.util.List;

public interface EmplService {
    List<Employee> getEmployees();
    Employee getOneById(int id);
    void add(Employee employee);
}
