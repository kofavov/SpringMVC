package com.webapp6.controllers;


import com.webapp6.dao.EmployeeDAO;
import com.webapp6.models.Employee;
import com.webapp6.util.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;


@Controller
public class MainController {
    private final EmployeeDAO employeeDAO;
    private final EmployeeValidator employeeValidator;
    @Autowired
    public MainController(EmployeeDAO employeeDAO, EmployeeValidator employeeValidator) {
        this.employeeDAO = employeeDAO;
        this.employeeValidator = employeeValidator;
    }



    @GetMapping("/view")
    public String view(@RequestParam(value = "name",
            required = false,
            defaultValue = "user") String name, Model model){
        model.addAttribute("name",name);
        return "/index";
    }
    @GetMapping("/employees")
    public String getEmployees(Model model) throws SQLException {

        model.addAttribute("employees",employeeDAO.getEmployees());
        return "/employees";
    }

    @GetMapping("/employees/new")
    public String getPageNewEmployee(Model model){
        model.addAttribute("employee",new Employee());
        return "/new";
    }
    @PostMapping("/employees/new")
    public String addNewEmployee(@ModelAttribute @Valid Employee employee, BindingResult bindingResult) throws SQLException {
        employeeValidator.validate(employee,bindingResult);
        if (bindingResult.hasErrors())
            return "/new";
        employeeDAO.add(employee);
        return "redirect:/employees";
    }
}
