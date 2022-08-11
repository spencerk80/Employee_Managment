package com.github.spencerk.employee_management.service;

import com.github.spencerk.employee_management.dao.EmployeeDao;
import com.github.spencerk.employee_management.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private  final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao dao) {
        employeeDao = dao;
    }

    //Create
    public String saveEmployee(Employee employee) {
        employeeDao.save(employee);
        return "Employee saved";
    }

    //Read
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> optional = employeeDao.findById(id);

        if(optional.isPresent()) return optional.get();
        return null;
    }

    //Update
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "Employee updated";
    }

    //Delete
    public String deleteEmployee(int id) {
        employeeDao.deleteById(id);
        return "Employee deleted";
    }
}
