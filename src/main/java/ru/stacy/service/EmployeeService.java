package ru.stacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stacy.model.Employee;
import ru.stacy.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee findOne(Long employeeId) {
        return employeeRepository.getOne(employeeId);
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    public Employee findByName(String name) {
        return employeeRepository.findByName(name);
    }
}
