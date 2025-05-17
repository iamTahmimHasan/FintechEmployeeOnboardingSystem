package com.selisegroup.FintechEmployeeOnboardingSystem.dto;


import com.selisegroup.FintechEmployeeOnboardingSystem.model.OnboardingStatus;
import lombok.Data;

@Data
public class EmployeeDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String position;
    private String department;
    private String hireDate;
    private OnboardingStatus status;
    private String createdAt;
    private String updatedAt;
}
