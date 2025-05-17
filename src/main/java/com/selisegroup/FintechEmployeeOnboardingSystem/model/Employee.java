package com.selisegroup.FintechEmployeeOnboardingSystem.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String phone;
    private String position;
    private String department;

    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    private OnboardingStatus status = OnboardingStatus.PENDING;

    private LocalDate createdAt = LocalDate.now();
    private LocalDate updatedAt = LocalDate.now();
}