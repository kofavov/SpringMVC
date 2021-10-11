package com.webapp6.controllers;

import com.webapp6.models.Company;

import com.webapp6.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CompanyController {
    final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public String getCompanies(Model model) {

        model.addAttribute("companies",companyService.getAllCompanies());
        return "/company/companies";
    }

    @GetMapping("/companies/new")
    public String getPageNewCompany(Model model){
        model.addAttribute("company",new Company());
        return "company/new";
    }
    @PostMapping("/companies/new")
    //убрал @Valid
    public String addNewCompany(@ModelAttribute @Valid Company company, BindingResult bindingResult)  {
//        employeeValidator.validate(employee,bindingResult);
        if (bindingResult.hasErrors())
            return "/company/new";
        companyService.add(company);
        return "redirect:/companies";
    }
    @GetMapping("/companies/{id}/edit")
    public String edit(Model model, @PathVariable("id")int id){
        Optional<Company> e=companyService.getOneById(id);
        if(e.isPresent()){
            model.addAttribute("company",e.get());
            return "/company/edit";}
        else return "redirect:/companies";
    }
    @PostMapping("/companies/{id}/edit")
    public String update(@ModelAttribute @Valid Company company, BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "/employee/edit";
        companyService.change(company,id);
        return "redirect:/companies";
    }
    @GetMapping("/companies/{id}/delete")
    public String delete(@PathVariable("id") int id){
        companyService.delete(id);
        return "redirect:/companies";

    }
    @GetMapping("/companies/sortbyname")
    public String sortByName(Model model){
        model.addAttribute("companies",companyService.getEmployeesSortByName());
        return "/company/companies";
    }
    @GetMapping("/companies/sortbysalary")
    public String sortBySalary(Model model){
        model.addAttribute("companies",companyService.getEmployeesSortBySalary());
        return "/company/companies";
    }
    @GetMapping("/companies/sortbyyear")
    public String sortByYear(Model model){
        model.addAttribute("companies",companyService.getEmployeesSortByYear());
        return "/company/companies";
    }
    @GetMapping("/companies/sortbyemployees")
    public String sortByEmployees(Model model){
        model.addAttribute("companies",companyService.getEmployeesSortByEmployees());
        return "/company/companies";
    }
}
