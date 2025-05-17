package com.selisegroup.FintechEmployeeOnboardingSystem.repository;

import com.selisegroup.FintechEmployeeOnboardingSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    boolean existsByEmail(String email);
}