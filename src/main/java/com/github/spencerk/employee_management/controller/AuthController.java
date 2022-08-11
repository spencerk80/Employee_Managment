package com.github.spencerk.employee_management.controller;

import com.github.spencerk.employee_management.model.UserLogin;
import com.github.spencerk.employee_management.service.AuthService;
import com.github.spencerk.employee_management.util.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService service) {
        authService = service;
    }

    @PostMapping()
    public ResponseEntity<String> authenticateUser(@RequestBody UserLogin user) {
        String username = user.getUsername();

        //Authenticate user and if invalid, return unauthorized
        if(authService.authenticateLogin(username, user.getPassword()))
            return ResponseEntity.status(401).body("");

        //Return JWT if authentication is successful
        return ResponseEntity.accepted().body(JWT.createJWT(username));
    }
}
