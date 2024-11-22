package com.rakshitpatel.esd_erp_project.controller;

import com.rakshitpatel.esd_erp_project.dto.LoginRequest;
import com.rakshitpatel.esd_erp_project.entity.Employee;
import com.rakshitpatel.esd_erp_project.helper.EncryptionService;
import com.rakshitpatel.esd_erp_project.helper.JWTHelper;
import com.rakshitpatel.esd_erp_project.repo.EmployeeRepo;
import com.rakshitpatel.esd_erp_project.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final EmployeeService employeeService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest loginRequest) {
        return ResponseEntity.ok(employeeService.login(loginRequest));
    }

}
