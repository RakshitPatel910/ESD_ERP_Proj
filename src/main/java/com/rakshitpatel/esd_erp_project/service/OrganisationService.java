package com.rakshitpatel.esd_erp_project.service;

import com.rakshitpatel.esd_erp_project.entity.Organisation;
import com.rakshitpatel.esd_erp_project.repo.OrganisationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganisationService {

    private final OrganisationRepo organisationRepo;

    public List<Organisation> getAllOrganisations() {
        return organisationRepo.findAll();
    }
}
