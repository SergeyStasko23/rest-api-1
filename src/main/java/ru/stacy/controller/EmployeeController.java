package ru.stacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stacy.model.Employee;
import ru.stacy.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
        Employee employee = employeeService.findOne(employeeId);

        if(employee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(employee);
    }

    @GetMapping("/employees/{name}")
    public Employee getEmployeeByName(@PathVariable final String name) {
        return employeeService.findByName(name);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId, @Valid @RequestBody Employee employeeDetails) {
        Employee employee = employeeService.findOne(employeeId);

        if(employee == null) {
            return ResponseEntity.notFound().build();
        }

        employee.setName(employeeDetails.getName());
        employee.setDesignation(employeeDetails.getDesignation());
        employee.setExpertise(employeeDetails.getExpertise());
        employee.setCreatedAt(employeeDetails.getCreatedAt());

        Employee updateEmployee = employeeService.save(employee);
        return ResponseEntity.ok().body(updateEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long employeeId) {
        Employee employee = employeeService.findOne(employeeId);

        if(employee == null) {
            return ResponseEntity.notFound().build();
        }

        employeeService.delete(employee);

        return ResponseEntity.ok().build();
    }
}


