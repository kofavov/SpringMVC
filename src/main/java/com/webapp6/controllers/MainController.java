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
        model.addAttribute("companies",companyService.getAllCompanies());
        return "/employee/edit";}
        else return "redirect:/employees";
    }
    @PostMapping("/employees/{id}/edit")
    public String update(@ModelAttribute @Valid Employee employee, BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "/employee/edit";
        try {
            emplService.change(employee,id);
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
        Optional<Company> e=companyService.getOneById(id);
        e.ifPresent(company -> model.addAttribute("company", company));
        return "/employee/employeesincompany";
    }

    @GetMapping("/employees/sortbyfio")
    public String sortByFio(Model model){
        model.addAttribute("employees",emplService.getEmployeesSortByFio());
        return "/employee/employees";
    }
    @GetMapping("/employees/sortbysalary")
    public String sortBySalary(Model model){
        model.addAttribute("employees",emplService.getEmployeesSortBySalary());
        return "/employee/employees";
    }
    @GetMapping("/employees/sortbycompany")
    public String sortByCompany(Model model){
        model.addAttribute("employees",emplService.getEmployeesSortByCompany());
        return "/employee/employees";
    }
    @GetMapping("/employees/sortbydob")
    public String sortByDob(Model model){
        model.addAttribute("employees",emplService.getEmployeesSortByDob());
        return "/employee/employees";
    }
    @GetMapping("/employees/findbyfio")
    public String findByFio(@RequestParam("fio") String s,Model model){
        model.addAttribute("employees",emplService.getEmployeesFindByFio(s));
        return "/employee/employees";
    }
    @GetMapping("/employees/findbysalary")
    public String findBySalary(@RequestParam(name = "i",required = false,defaultValue = "-2147483648") int i,
                            @RequestParam(name = "j",required = false,defaultValue = "2147483647") int j,
                            Model model){

        model.addAttribute("employees",emplService.getEmployeesFindBySalary(i,j));
        return "/employee/employees";
    }
    @GetMapping("/employees/findbyfio/{cid}")
    public String findByFioAndCompany(@RequestParam("fio") String s,
                                      @PathVariable("cid") int cid,
                                      Model model){
        model.addAttribute("employees",emplService.getEmployeesFindByFioAndCompany(s, cid));
        Optional<Company> e=companyService.getOneById(cid);
        e.ifPresent(company -> model.addAttribute("company", company));
        return "/employee/employeesincompany";
    }
    @GetMapping("/employees/findbysalary/{cid}")
    public String findBySalaryAndCompany(@RequestParam(name = "i",required = false,defaultValue = "-2147483648") int i,
                                         @RequestParam(name = "j",required = false,defaultValue = "2147483647") int j,
                                         @PathVariable("cid") int cid,
                                         Model model){

        model.addAttribute("employees",emplService.getEmployeesFindBySalaryAndCompany(i,j,cid));
        Optional<Company> e=companyService.getOneById(cid);
        e.ifPresent(company -> model.addAttribute("company", company));
        return "/employee/employeesincompany";
    }
}
