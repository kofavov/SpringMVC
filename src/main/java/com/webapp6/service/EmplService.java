package com.webapp6.service;

import com.webapp6.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmplService {
    List<Employee> getEmployees();
    Optional<Employee> getOneById(int id);
    void add(Employee employee);
    void change(Employee employee,int id);

    void delete(int id);
}
