package ru.stacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stacy.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByName(String name);
}
