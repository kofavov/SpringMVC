package com.webapp6.service;

import com.webapp6.models.Employee;
import com.webapp6.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class EmplServiceImpl implements EmplService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees=employeeRepository.findAllByIdOrderById();
        return employees;
    }

    @Override
    public Optional<Employee> getOneById(int id) {
        return employeeRepository.findById(id);
    }

    @Transactional
    @Override
    public void add(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void change(Employee employee, int id) {
        Optional<Employee> o = employeeRepository.findById(id);
        if (o.isPresent()){
        Employee e = o.get();
        e.setFio(employee.getFio());
        e.setSalary(employee.getSalary());
        e.setDob(employee.getDob());
        e.setCompanyid(employee.getCompanyid());
         employeeRepository.save(e);}
    }

    @Override
    @Transactional
    public void delete(int id) {
    employeeRepository.deleteById(id);
    }


}
