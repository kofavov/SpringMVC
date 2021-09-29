package com.webapp6.dao;

import com.webapp6.models.Employee;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;
@Component
@EnableTransactionManagement
@Transactional(readOnly = true)
public class JPAEmplDAO implements EmplDAO{
    @PersistenceContext(unitName = "emf")
    private EntityManager entityManager;

    @Override
    public List<Employee> getEmployees() {
        return entityManager.createQuery("SELECT e from Employee e",Employee.class).getResultList();
    }

    @Override
    public Employee getOneById(int id) {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e from Employee e where e.id=:id",Employee.class);
        query.setParameter("id",id);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public void add(Employee employee) {
        entityManager.persist(employee);
    }
}
