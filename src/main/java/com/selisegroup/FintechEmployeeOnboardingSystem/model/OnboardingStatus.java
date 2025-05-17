package com.selisegroup.FintechEmployeeOnboardingSystem.model;

public enum OnboardingStatus {
    PENDING,       // Employee onboarding is in progress
    ONBOARDED,     // Employee has completed onboarding
    REJECTED,      // Employee onboarding was rejected
    IN_REVIEW      // Additional status for HR review
}