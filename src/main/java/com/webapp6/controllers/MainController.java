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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
    public String addNewEmployee(@ModelAttribute Employee employee, BindingResult bindingResult)  {
//        employeeValidator.validate(employee,bindingResult);
//        if (bindingResult.hasErrors())
//            return "/new";
        emplService.add(employee);
        return "redirect:/employees";
    }
}
