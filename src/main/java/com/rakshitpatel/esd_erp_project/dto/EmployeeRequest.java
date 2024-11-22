package com.rakshitpatel.esd_erp_project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;


public record EmployeeRequest(
        @NotNull(message = "name needed")
        @NotEmpty(message = "name needed")
        @NotBlank(message = "name needed")
        @JsonProperty("first_name")
        String firstName,

        @JsonProperty("last_name")
        String lastName,

        @NotNull(message = "email needed")
        @NotEmpty(message = "email needed")
        @Email(message = "Email must be in correct format")
        @JsonProperty("email")
        String email,

        @NotNull(message = "department id needed")
        @Positive(message = "enter valid department id")
        @JsonProperty("department_id")
        Long departmentId,

        @NotNull(message = "password needed")
        @NotEmpty(message = "password needed")
        @NotBlank(message = "password needed")
        @Size(min = 8, max = 12)
        @JsonProperty("password")
        String password
) {
}

