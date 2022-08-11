package com.github.spencerk.employee_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.spencerk.employee_management.enums.EmployeeLevel;
import com.github.spencerk.employee_management.util.Password;

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
                            phone,
                            username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String          pswd;
    private EmployeeLevel   employeeLevel;

    public Employee() {}

    public Employee(String fname, String lname, String email, String phone, String username,
                    String pswd, EmployeeLevel employeeLevel) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.pswd = Password.encodePassword(pswd);
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPswd() { return pswd; }

    public void setPswd(String pswd) {
        this.pswd = Password.encodePassword(pswd);
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
        return String.format(
                "Employee{\n\tid=%d,\n\tfname=%s,\n\tlname=%s,\n\temail=%s,\n\tphone=%s,\n\tusername=%s," +
                        "\n\temployeeLevel=%s\n}",
                id, fname, lname,email, phone, username, employeeLevel
        );
    }
}
