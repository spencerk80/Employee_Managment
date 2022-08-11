package com.github.spencerk.employee_management.service;

import com.github.spencerk.employee_management.dao.EmployeeDao;
import com.github.spencerk.employee_management.util.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private EmployeeDao employeeDao;

    @Autowired
    public AuthService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public boolean authenticateLogin(String username, String plainText) {
        String hash = employeeDao.getPasswordHash(username);

        //Username not valid. Didn't return a matching hash
        if(hash == null || hash == "") return false;

        return Password.validatePassword(plainText, hash);
    }
}
