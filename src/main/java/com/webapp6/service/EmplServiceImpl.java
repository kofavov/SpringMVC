package com.webapp6.service;

import com.webapp6.models.Employee;
import com.webapp6.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
public class EmplServiceImpl implements EmplService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getOneById(int id) {
        return employeeRepository.getById(id);
    }

    @Transactional
    @Override
    public void add(Employee employee) {
        employeeRepository.save(employee);
    }
}
