package com.selisegroup.FintechEmployeeOnboardingSystem.service;


import com.selisegroup.FintechEmployeeOnboardingSystem.dto.EmployeeCreateDto;
import com.selisegroup.FintechEmployeeOnboardingSystem.dto.EmployeeDto;
import com.selisegroup.FintechEmployeeOnboardingSystem.model.Employee;
import com.selisegroup.FintechEmployeeOnboardingSystem.model.OnboardingStatus;
import com.selisegroup.FintechEmployeeOnboardingSystem.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public EmployeeDto createEmployee(EmployeeCreateDto createDto) {
        // Check if employee with this email already exists
        if (employeeRepository.existsByEmail(createDto.getEmail())) {
            throw new RuntimeException("Employee with email " + createDto.getEmail() + " already exists");
        }

        // Map DTO to Entity
        Employee employee = modelMapper.map(createDto, Employee.class);

        // Set default status
        employee.setStatus(OnboardingStatus.PENDING);

        // Save to database
        Employee savedEmployee = employeeRepository.save(employee);

        // Map Entity back to DTO for response
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public EmployeeDto getEmployeeById(String id) {
        Employee employee = employeeRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Transactional
    public EmployeeDto updateEmployeeStatus(String id, OnboardingStatus newStatus) {
        Employee employee = employeeRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        employee.setStatus(newStatus);
        employee.setUpdatedAt(LocalDate.now());

        Employee updatedEmployee = employeeRepository.save(employee);
        return modelMapper.map(updatedEmployee, EmployeeDto.class);
    }
}