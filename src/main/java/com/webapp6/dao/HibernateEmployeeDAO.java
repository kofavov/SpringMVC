package com.webapp6.dao;

import com.webapp6.models.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
//@Component
//public class HibernateEmployeeDAO implements EmplDAO{
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    private Session currentSession(){
//        return sessionFactory.openSession();
//    }
//    @Override
//    public List<Employee> getEmployees() {
//        String hql = String.format("from %s",Employee.class.getCanonicalName());
//        return currentSession().createQuery(hql,Employee.class).list();
//    }
//
//    @Override
//    public Employee getOneById(int id) {
//        String hql = String.format("from %s where id=:%d",Employee.class.getCanonicalName(),id);
//        Query<Employee> query = currentSession().createQuery(hql,Employee.class);
//        query.setParameter("id",id);
//        return query.list().stream().findAny().orElse(null);
//    }
//
//    @Override
//    public void add(Employee employee) {
//        currentSession().save(employee);
//    }
//}
