package com.rakshitpatel.esd_erp_project.controller;

import com.rakshitpatel.esd_erp_project.entity.Domain;
import com.rakshitpatel.esd_erp_project.entity.Organisation;
import com.rakshitpatel.esd_erp_project.entity.Specialisation;
import com.rakshitpatel.esd_erp_project.service.DomainService;
import com.rakshitpatel.esd_erp_project.service.OrganisationService;
import com.rakshitpatel.esd_erp_project.service.SpecialisationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("data")
@RequiredArgsConstructor
public class DataController {

    private final OrganisationService organisationService;
    private final DomainService domainService;
    private final SpecialisationService specialisationService;

    @GetMapping("/organisation")
    public ResponseEntity<List<Organisation>> getAllOrganisations() {
        return ResponseEntity.ok(organisationService.getAllOrganisations());
    }

    @GetMapping("/domain")
    public ResponseEntity<List<Domain>> getAllDomains() {
        return ResponseEntity.ok(domainService.getAllDomain());
    }

    @GetMapping("/specialisation")
    public ResponseEntity<List<Specialisation>> getAllSpecialisations() {
        return ResponseEntity.ok(specialisationService.getAllSpecialisation());
    }

}
