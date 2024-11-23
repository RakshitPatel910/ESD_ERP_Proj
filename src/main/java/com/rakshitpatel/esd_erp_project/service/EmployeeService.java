package com.rakshitpatel.esd_erp_project.service;

import com.rakshitpatel.esd_erp_project.dto.LoginRequest;
import com.rakshitpatel.esd_erp_project.entity.Employee;
import com.rakshitpatel.esd_erp_project.helper.EncryptionService;
import com.rakshitpatel.esd_erp_project.helper.JWTHelper;
import com.rakshitpatel.esd_erp_project.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;

    public String login(LoginRequest req){
        Employee employee = employeeRepo.findByEmail(req.email())
                .orElseThrow( () -> new RuntimeException("Employee not found with email: " + req.email()) );

        if(!encryptionService.validate(req.password(), encryptionService.encryptPassword(employee.getPassword()))){
            return "Incorrect password";
        }

        if(employee.getDepartmentId() != 3){
            return "Employee not from Outreach Department";
        }

        return jwtHelper.generateToken(req.email());
    }
    
}
