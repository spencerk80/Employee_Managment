package com.github.spencerk.employee_management.dao;

import com.github.spencerk.employee_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT pswd FROM employee WHERE username = ?1", nativeQuery = true)
    String getPasswordHash(String username);
}
