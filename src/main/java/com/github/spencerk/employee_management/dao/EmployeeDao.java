package com.github.spencerk.employee_management.dao;

import com.github.spencerk.employee_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
    //Write custom queries here if standard set doesn't cover everything
}
