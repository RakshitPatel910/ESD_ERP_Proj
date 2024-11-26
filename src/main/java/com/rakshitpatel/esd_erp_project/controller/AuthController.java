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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final EmployeeService employeeService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest loginRequest) {
        return ResponseEntity.ok(employeeService.login(loginRequest));
    }

    @PostMapping("/validateToken")
    public ResponseEntity<Boolean> validateAuthToken(@RequestHeader("Authorization") String authToken) {
        return ResponseEntity.ok(employeeService.valToken(authToken));
    }

}
