package com.rakshitpatel.esd_erp_project.service;

import com.rakshitpatel.esd_erp_project.dto.LoginRequest;
import com.rakshitpatel.esd_erp_project.entity.Employee;
import com.rakshitpatel.esd_erp_project.helper.EncryptionService;
import com.rakshitpatel.esd_erp_project.helper.JWTHelper;
import com.rakshitpatel.esd_erp_project.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
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

        System.out.println("This is the email : " + employee.getEmail());

        System.out.println("This is the enc pass : " + encryptionService.encryptPassword(employee.getPassword()));

        if(!encryptionService.validate(req.password(), employee.getPassword())){
            return "Incorrect password";
        }

        System.out.println("This is the dept id : " + employee.getDepartmentId());

        if(employee.getDepartmentId() != 3){
            throw new BadCredentialsException("Employee from non authorized department.");
//            return "Employee not from Outreach Department";
        }

        return jwtHelper.generateToken(req.email());
    }

    public Boolean valToken(String token){
        String email = jwtHelper.extractUsername(token);

        Employee employee = employeeRepo.findByEmail(email).orElseThrow( () -> new RuntimeException("Employee not found with email: " + email));

        return jwtHelper.validateToken(token, encryptionService.encryptPassword(employee.getPassword()));
    }
    
}
