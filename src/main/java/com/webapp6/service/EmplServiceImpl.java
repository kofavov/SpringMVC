package com.webapp6.service;

import com.webapp6.exception.CompanyNotFoundException;
import com.webapp6.models.Company;
import com.webapp6.models.Employee;
import com.webapp6.repository.CompanyRepository;
import com.webapp6.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class EmplServiceImpl implements EmplService {
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    public EmplServiceImpl(EmployeeRepository employeeRepository, CompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees=employeeRepository.findAllOrderById();
        return employees;
    }

    @Override
    public Optional<Employee> getOneById(int id) {
        return employeeRepository.findById(id);
    }

    @Transactional
    @Override
    public void add(Employee employee) throws CompanyNotFoundException {
        Optional<Company> company = companyRepository.findByName(employee.getC());
        if (company.isPresent()){
            employee.setCompany(company.get());
            employeeRepository.save(employee);
        }else {
            throw new CompanyNotFoundException("");
        }

    }

    @Override
    @Transactional
    public void change(Employee employee, int id) throws CompanyNotFoundException {
        Optional<Employee> o = employeeRepository.findById(id);
        if (o.isPresent()){
        Employee e = o.get();
        e.setFio(employee.getFio());
        e.setSalary(employee.getSalary());
        e.setDob(employee.getDob());
        Optional<Company> company = companyRepository.findByName(employee.getC());
        if (company.isPresent()){
            employee.setCompany(company.get());
            employeeRepository.save(employee);
        }else {
            throw new CompanyNotFoundException("");
        }
        employeeRepository.save(e);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
    employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeesForCompany(int id) {
        return employeeRepository.findAllByCompanyId(id);
    }


}
