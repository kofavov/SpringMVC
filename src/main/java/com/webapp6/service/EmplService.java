package com.webapp6.service;

import com.webapp6.exception.CompanyNotFoundException;
import com.webapp6.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmplService {
    List<Employee> getEmployees();
    Optional<Employee> getOneById(int id);
    void add(Employee employee) throws CompanyNotFoundException;
    void change(Employee employee,int id) throws CompanyNotFoundException;

    void delete(int id);

    List<Employee> getEmployeesForCompany(int id);

    List<Employee>  getEmployeesSortByFio();

    List<Employee> getEmployeesSortBySalary();

    List<Employee> getEmployeesSortByCompany();

    List<Employee> getEmployeesSortByDob();
}
