package com.webapp6.service;

import com.webapp6.models.Company;
import com.webapp6.models.Employee;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> getAllCompanies();
    Optional<Company> getOneById(int id);
    void add(Company company);
    void change(Company company,int id);

    void delete(int id);
}
