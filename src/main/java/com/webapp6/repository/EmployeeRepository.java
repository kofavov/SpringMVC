package com.webapp6.repository;

import com.webapp6.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query("select e from Employee e order by e.id")
    List<Employee> findAllOrderById();
    List<Employee> findAllByCompanyId(int id);
    List<Employee> findByFioContaining(String s);
    List<Employee> findAllBySalaryBetween(int i,int j);
    List<Employee> findAllBySalaryBetweenAndCompanyId(int i,int j,int companyid);
    List<Employee> findByFioAndCompanyId(String s,int companyid);
}
