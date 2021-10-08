package com.webapp6.controllers;


//import com.webapp6.dao.HibernateEmployeeDAO;
//import com.webapp6.dao.JPAEmplDAO;
import com.webapp6.exception.CompanyNotFoundException;
import com.webapp6.models.Company;
import com.webapp6.models.Employee;
//import com.webapp6.util.EmployeeValidator;
import com.webapp6.service.CompanyService;
import com.webapp6.service.EmplService;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Controller
public class MainController {
    private final EmplService emplService;
    private final CompanyService companyService;

    public MainController(EmplService emplService, CompanyService companyService) {
        this.emplService = emplService;
        this.companyService = companyService;
    }
//    private final EmployeeValidator employeeValidator;
//    @Autowired
//    public MainController(JPAEmplDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
////        this.employeeValidator = employeeValidator;
//    }
    
    @GetMapping("/")
    public String home(){
        return "/home";
    }
    @GetMapping("/employees")
    public String getEmployees(Model model) {

        model.addAttribute("employees",emplService.getEmployees());
        return "/employee/employees";
    }

    @GetMapping("/employees/new")
    public String getPageNewEmployee(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("companies",companyService.getAllCompanies());
        model.addAttribute("company",new Company());
        return "/employee/new";
    }
    @PostMapping("/employees/new")
    //убрал @Valid
    public String addNewEmployee(@ModelAttribute  @Valid Employee employee, BindingResult bindingResult)  {
//        employeeValidator.validate(employee,bindingResult);
        if (bindingResult.hasErrors())
            return "/employee/new";

        try {
            emplService.add(employee);
            return "redirect:/employees";
        }catch (CompanyNotFoundException exception){
            return "/companyNotFoundException";
        }

    }
    @GetMapping("/employees/{id}/edit")
    public String edit(Model model, @PathVariable("id")int id){
        Optional<Employee>e=emplService.getOneById(id);
        if(e.isPresent()){
        model.addAttribute("employee",e.get());
        return "/employee/edit";}
        else return "redirect:/employees";
    }
    @PostMapping("/employees/{id}/edit")
    public String update(@ModelAttribute @Valid Employee employee, BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "/employee/edit";
        try {
            emplService.add(employee);
            return "redirect:/employees";
        }catch (CompanyNotFoundException exception){
           return "/companyNotFoundException";
        }

    }
    @GetMapping("/employees/{id}/delete")
    public String delete(@PathVariable("id") int id){
        emplService.delete(id);
        return "redirect:/employees";

    }
    @GetMapping("/employees/{id}/getListForCompany")
    public String getListForCompany(@PathVariable("id") int id,Model model){
        model.addAttribute("employees",emplService.getEmployeesForCompany(id));
        return "/employee/employees";
    }
}
