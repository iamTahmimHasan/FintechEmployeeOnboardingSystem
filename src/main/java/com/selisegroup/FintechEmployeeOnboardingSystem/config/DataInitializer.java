package com.selisegroup.FintechEmployeeOnboardingSystem.config;

import com.selisegroup.FintechEmployeeOnboardingSystem.model.User;
import com.selisegroup.FintechEmployeeOnboardingSystem.model.UserRole;
import com.selisegroup.FintechEmployeeOnboardingSystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        initializeDefaultUsers();
    }

    private void initializeDefaultUsers() {
        // Create admin user if not exists
        if (!userRepository.existsByUsername("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setEmail("admin@fintech.com");
            admin.setRole(UserRole.ADMIN);
            admin.setEnabled(true);
            userRepository.save(admin);
        }

        // Create HR user if not exists
        if (!userRepository.existsByUsername("hr")) {
            User hr = new User();
            hr.setUsername("hr");
            hr.setPassword(passwordEncoder.encode("hr123"));
            hr.setEmail("hr@fintech.com");
            hr.setRole(UserRole.HR);
            hr.setEnabled(true);
            userRepository.save(hr);
        }

        // Create sample employee user if not exists
        if (!userRepository.existsByUsername("employee")) {
            User employee = new User();
            employee.setUsername("employee");
            employee.setPassword(passwordEncoder.encode("employee123"));
            employee.setEmail("employee@fintech.com");
            employee.setRole(UserRole.EMPLOYEE);
            employee.setEnabled(true);
            userRepository.save(employee);
        }
    }
}