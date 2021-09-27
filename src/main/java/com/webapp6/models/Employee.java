package com.webapp6.models;

public class Employee {
    private int id;
    private String fio;
    private int salary;
//    private Date dob;
    private int companyid;
//    private String dobs;

//    public String getDobs() {
//        return dobs;
//    }
//
//    public void setDobs(String dobs) {
//        this.dobs = dobs;
//    }

    public Employee(int id, String fio, int salary,  int companyid) {
        this.id = id;
        this.fio = fio;
        this.salary = salary;
//        this.dob = dob;
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

//    public Date getDob() {
//        return dob;
//    }

//    public void setDob(Date dob) {
//        this.dob = dob;
//    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }
}
