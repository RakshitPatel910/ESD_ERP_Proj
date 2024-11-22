package com.rakshitpatel.esd_erp_project.mapper;

import com.rakshitpatel.esd_erp_project.dto.EmployeeRequest;
import com.rakshitpatel.esd_erp_project.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

    public Employee toEmployee(EmployeeRequest req){
        return Employee.builder()
                .firstName(req.firstName())
                .lastName(req.lastName())
                .email(req.email())
                .departmentId(req.departmentId())
                .password(req.password())
                .build();
    }

}
