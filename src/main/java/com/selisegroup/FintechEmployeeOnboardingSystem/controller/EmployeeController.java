package com.selisegroup.FintechEmployeeOnboardingSystem.controller;

import com.selisegroup.FintechEmployeeOnboardingSystem.dto.EmployeeCreateDto;
import com.selisegroup.FintechEmployeeOnboardingSystem.dto.EmployeeDto;
import com.selisegroup.FintechEmployeeOnboardingSystem.model.OnboardingStatus;
import com.selisegroup.FintechEmployeeOnboardingSystem.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeCreateDto createDto) {
        EmployeeDto employee = employeeService.createEmployee(createDto);
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable String id) {
        EmployeeDto employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<EmployeeDto> updateEmployeeStatus(
            @PathVariable String id,
            @RequestParam OnboardingStatus status) {
        EmployeeDto employee = employeeService.updateEmployeeStatus(id, status);
        return ResponseEntity.ok(employee);
    }
}