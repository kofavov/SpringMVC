package com.webapp6.repository;

import com.webapp6.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByCompanyid(int id);
    Employee findByFio(String s);
    Employee findAllByCompanyid(int id);
}
