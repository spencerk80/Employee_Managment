package com.github.spencerk.employee_management.entity;

import com.github.spencerk.employee_management.enums.EmployeeLevel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int             id;
    private String          fname,
                            lname,
                            email,
                            phone;
    private EmployeeLevel   employeeLevel;

    public Employee() {}

    public Employee(String fname, String lname, String email, String phone, EmployeeLevel employeeLevel) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.employeeLevel = employeeLevel;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EmployeeLevel getEmployeeLevel() {
        return employeeLevel;
    }

    public void setEmployeeLevel(EmployeeLevel employeeLevel) {
        this.employeeLevel = employeeLevel;
    }

    @Override
    public boolean equals(Object o) {
        Employee employee;

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        employee = (Employee) o;

        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", employeeLevel=" + employeeLevel +
                '}';
    }
}
