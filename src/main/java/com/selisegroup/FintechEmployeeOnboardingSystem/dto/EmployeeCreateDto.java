package com.selisegroup.FintechEmployeeOnboardingSystem.dto;

import lombok.Data;

@Data
public class EmployeeCreateDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String position;
    private String department;
    private String hireDate;
}