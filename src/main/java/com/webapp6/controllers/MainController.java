package com.webapp6.controllers;


//import com.webapp6.dao.HibernateEmployeeDAO;
import com.webapp6.dao.EmplDAO;
//import com.webapp6.dao.JPAEmplDAO;
import com.webapp6.models.Employee;
//import com.webapp6.util.EmployeeValidator;
import com.webapp6.service.EmplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Controller
public class MainController {
    @Autowired

    private EmplService emplService;
//    private final EmployeeValidator employeeValidator;
//    @Autowired
//    public MainController(JPAEmplDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
////        this.employeeValidator = employeeValidator;
//    }

//    @GetMapping("/view")
//    public String view(@RequestParam(value = "name",
//            required = false,
//            defaultValue = "user") String name, Model model){
//        model.addAttribute("name",name);
//        return "/index";
//    }
    @GetMapping("/employees")
    public String getEmployees(Model model) {

        model.addAttribute("employees",emplService.getEmployees());
        return "/employees";
    }

    @GetMapping("/employees/new")
    public String getPageNewEmployee(Model model){
        model.addAttribute("employee",new Employee());
        return "/new";
    }
    @PostMapping("/employees/new")
    //убрал @Valid
    public String addNewEmployee(@ModelAttribute  @Valid Employee employee, BindingResult bindingResult)  {
//        employeeValidator.validate(employee,bindingResult);
        if (bindingResult.hasErrors())
            return "/new";
        emplService.add(employee);
        return "redirect:/employees";
    }
    @GetMapping("/employees/{id}/edit")
    public String edit(Model model, @PathVariable("id")int id){
        Optional<Employee>e=emplService.getOneById(id);
        if(e.isPresent()){
        model.addAttribute("employee",e.get());
        return "/edit";}
        else return "redirect:/employees";
    }
    @PostMapping("/employees/{id}/edit")
    public String update(@ModelAttribute @Valid Employee employee, BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "/edit";
        emplService.change(employee,id);
        return "redirect:/employees";
    }
    @GetMapping("/employees/{id}/delete")
    public String delete(@PathVariable("id") int id){
        emplService.delete(id);
        return "redirect:/employees";

    }
}
