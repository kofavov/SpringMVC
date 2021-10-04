package com.webapp6.models;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    private int id;
    @Basic
    @NotBlank(message = "fio is required")
    private String fio;
    @Basic
    private int salary;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="dob")
    private Date dob;


    @Min(value = 0,message = "Min id = 0")
    private int companyid;


    public Employee(int id, String fio, int salary,  int companyid,Date dob) {
        this.id = id;
        this.fio = fio;
        this.salary = salary;
        this.dob = dob;
        this.companyid = companyid;
//        this.dobs = Integer.toString(dob.getYear())+"-"+Integer.toString(dob.getMonth())+"-"+Integer.toString(dob.getDay());
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }
}
