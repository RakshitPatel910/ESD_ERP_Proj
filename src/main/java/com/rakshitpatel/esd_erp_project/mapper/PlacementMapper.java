package com.rakshitpatel.esd_erp_project.mapper;

import com.rakshitpatel.esd_erp_project.dto.PlacementRequest;
import com.rakshitpatel.esd_erp_project.entity.*;
import com.rakshitpatel.esd_erp_project.repo.DomainRepo;
import com.rakshitpatel.esd_erp_project.repo.SpecialisationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlacementMapper {

    private final DomainRepo domainRepo;
    private final SpecialisationRepo specialisationRepo;

    public Placement toPlacement(PlacementRequest req) {
        Placement placement = new Placement();

        placement.setOrganisationId(req.organisation_id());
        placement.setProfile(req.profile());
        placement.setDescription(req.description());
        placement.setMinGrade(req.minGrade());
        placement.setIntake(req.intake());

        if( req.domainIds() != null && !req.domainIds().isEmpty()) {
            List<PlacementDomain> placementDomains = req.domainIds().stream()
                    .map( domainId -> {
                        Domain domain = domainRepo.findById(domainId)
                                .orElseThrow(() -> new RuntimeException("Domain with id " + domainId + " not found"));

                        return PlacementDomain.builder()
                                .domain(domain)
                                .placement(placement)
                                .build();
                    })
                    .toList();

            placement.setDomains(placementDomains);
        }

        if( req.specialisationIds() != null && !req.specialisationIds().isEmpty() ) {
            List<PlacementSpecialisation> placementSpecialisations = req.specialisationIds().stream()
                    .map( specialisationId -> {
                        Specialisation specialisation = specialisationRepo.findById(specialisationId)
                                .orElseThrow(() -> new RuntimeException("Specialisation with id " + specialisationId + " not found"));

                        return PlacementSpecialisation.builder()
                                .specialisation(specialisation)
                                .placement(placement)
                                .build();
                    })
                    .toList();

            placement.setSpecialisations(placementSpecialisations);
        }

        return placement;
    }




}
