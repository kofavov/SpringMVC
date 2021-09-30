package com.webapp6.util;

//import com.webapp6.dao.EmployeeDAO;
//import com.webapp6.models.Employee;
//import com.webapp6.service.EmplService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//@Component
//public class EmployeeValidator implements Validator {
//
//    @Autowired
//    private EmplService emplService;
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Employee.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Employee employee = (Employee) target;
//        if (emplService.getOneById(employee.getId())!=null){
//            errors.rejectValue("id","","This id is already in use");
//        }
//
//    }
//}
