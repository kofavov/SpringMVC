package com.webapp6.service;

import com.webapp6.models.Company;
import com.webapp6.models.Employee;
import com.webapp6.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = companyRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
        companies.forEach(c->{c.setEmployeesSize(c.getEmployees().size());
            double allSalaries = 0;
            for (Employee e:c.getEmployees()
                 ) {
                allSalaries+=e.getSalary();
            }
            c.setAverageSalary(allSalaries/c.getEmployees().size());
            if(Double.isNaN(c.getAverageSalary())||Double.isInfinite(c.getAverageSalary()))
                c.setAverageSalary(0);
        });

        return companies;
    }

    @Override
    public Optional<Company> getOneById(int id) {
        return companyRepository.findById(id);
    }

    @Override
    @Transactional
    public void add(Company company) {
        companyRepository.save(company);
    }

    @Override
    @Transactional
    public void change(Company company, int id) {
        Optional<Company> o = companyRepository.findById(id);
        if (o.isPresent()){
            Company c = o.get();
            c.setName(company.getName());
            c.setOpenyear(company.getOpenyear());
            companyRepository.save(c);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        companyRepository.deleteById(id);
    }

    @Override
    public List<Company> getEmployeesSortByName() {
        List<Company> companies = getAllCompanies();
        companies.sort(Comparator.comparing(Company::getName));
        return companies;
    }

    @Override
    public List<Company> getEmployeesSortByYear() {
        List<Company> companies = getAllCompanies();
        companies.sort(Comparator.comparing(Company::getOpenyear));
        return companies;
    }

    @Override
    public List<Company> getEmployeesSortBySalary() {
        List<Company> companies = getAllCompanies();
        companies.sort(Comparator.comparing(Company::getAverageSalary));
        return companies;
    }

    @Override
    public List<Company> getEmployeesSortByEmployees() {
        List<Company> companies = getAllCompanies();
        companies.sort(Comparator.comparing(Company::getEmployeesSize));
        return companies;
    }
}
