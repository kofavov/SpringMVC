package com.webapp6.service;

import com.webapp6.models.Company;
import com.webapp6.models.Employee;
import com.webapp6.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = companyRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
        companies.forEach(c->c.setEmployeesSize(c.getEmployees().size()));
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
}
