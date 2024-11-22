package com.rakshitpatel.esd_erp_project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record PlacementRequest(
        @NotNull(message = "organisation needed")
        @Positive(message = "enter valid organisation id")
        @JsonProperty("organisation_id")
        Long organisation_id,

        @JsonProperty("profile")
        String profile,

        @JsonProperty("description")
        String description,

        @Positive(message = "enter valid grades")
        @Max(value = 4)
        @JsonProperty("min_grade")
        Double minGrade,

        @Positive(message = "enter valid intake")
        @JsonProperty("intake")
        Integer intake,

        @JsonProperty("domain_ids")
        List<@Positive(message = "enter valid domain ids") Long> domainIds,

        @JsonProperty("specialisation_id")
        List<@Positive(message = "enter valid specialisation ids") Long> specialisationIds
) {
}
