package com.webapp6.controllers;


import com.webapp6.models.Employee;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@Controller
public class MainController {
    @GetMapping("/view")
    public String view(@RequestParam(value = "name",
            required = false,
            defaultValue = "user") String name, Model model){
        model.addAttribute("name",name);
        return "/index";
    }
    @GetMapping("/employees")
    public String getEmployees(Model model){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"a",1000, new Date(2000, Calendar.MARCH,12),1));
        employees.add(new Employee(2,"b",2000, new Date(1990, Calendar.JUNE, 2),2));
        model.addAttribute("employees",employees);
        return "/employees";
    }
}
