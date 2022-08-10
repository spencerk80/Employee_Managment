package com.github.spencerk.employee_management.controller;

import com.github.spencerk.employee_management.entity.Employee;
import com.github.spencerk.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{empID}")
    public Employee getEmployee(@PathVariable int empID) {
        return employeeService.getEmployeeById(empID);
    }

    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees")
    public String updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{empID}")
    public String deleteEmployee(@PathVariable int empID) {
        return employeeService.deleteEmployee(empID);
    }
}
