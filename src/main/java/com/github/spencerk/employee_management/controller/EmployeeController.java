package com.github.spencerk.employee_management.controller;

import com.github.spencerk.employee_management.entity.Employee;
import com.github.spencerk.employee_management.service.EmployeeService;
import com.github.spencerk.employee_management.util.JWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeController {
    private final EmployeeService employeeService;

    private boolean checkJwtIsInvalid(String jwt) {
        Claims claims;

        try {
            claims = JWT.validateJwt(jwt);
        } catch(ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException e) {
            return true;
        }

        //Check that a username comes back out of the jwt.
        //For this simple demo, this is sufficient. No claims are really used. There's no authorization in place
        return claims.get("username").equals("");
    }

    @Autowired
    public EmployeeController(EmployeeService service) { employeeService = service; }

    @GetMapping("employees")
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestHeader("jwt") String jwt) {
        if(checkJwtIsInvalid(jwt)) return ResponseEntity.status(401).body(null);

        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @GetMapping("employees/{empID}")
    public ResponseEntity<Employee> getEmployee(@RequestHeader("jwt") String jwt, @PathVariable int empID) {
        if(checkJwtIsInvalid(jwt)) return ResponseEntity.status(401).body(null);

        return ResponseEntity.ok().body(employeeService.getEmployeeById(empID));
    }

    @PostMapping("employees")
    public ResponseEntity<String> saveEmployee(@RequestHeader("jwt") String jwt, @RequestBody Employee employee) {
        URI uri;

        if(checkJwtIsInvalid(jwt)) return ResponseEntity.status(401).body(null);

        uri = URI.create(
                ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/employees").toUriString()
        );

        return ResponseEntity.created(uri).body(employeeService.saveEmployee(employee));
    }

    @PutMapping("employees")
    public ResponseEntity<String> updateEmployee(@RequestHeader("jwt") String jwt, @RequestBody Employee employee) {
        URI uri;

        if(checkJwtIsInvalid(jwt)) return ResponseEntity.status(401).body(null);

        uri = URI.create(
                ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/employees").toUriString()
        );

        return ResponseEntity.created(uri).body(employeeService.updateEmployee(employee));
    }

    @DeleteMapping("employees/{empID}")
    public ResponseEntity<String> deleteEmployee(@RequestHeader("jwt") String jwt, @PathVariable int empID) {
        if(checkJwtIsInvalid(jwt)) return ResponseEntity.status(401).body(null);

        return ResponseEntity.ok().body(employeeService.deleteEmployee(empID));
    }
}
