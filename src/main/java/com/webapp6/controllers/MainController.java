package com.webapp6.controllers;


import com.webapp6.dao.EmployeeDAO;
import com.webapp6.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private EmployeeDAO employeeDAO;

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
    public String addNewEmployee(@ModelAttribute @Valid Employee employee, BindingResult bindingResult){
//        Date date = new Date(Integer.parseInt(dob.substring(0,dob.indexOf("-"))),
//                Integer.parseInt(dob.substring(dob.indexOf("-")+1,dob.lastIndexOf("-"))),
//                Integer.parseInt(dob.substring(dob.lastIndexOf("-"),dob.length())));
        if (bindingResult.hasErrors())
            return "/new";
//        employees.add(employee);
        return "redirect:/employees";
    }
}
