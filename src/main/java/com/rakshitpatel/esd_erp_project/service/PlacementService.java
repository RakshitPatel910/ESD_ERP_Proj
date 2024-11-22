package com.rakshitpatel.esd_erp_project.service;

import com.rakshitpatel.esd_erp_project.dto.PlacementRequest;
import com.rakshitpatel.esd_erp_project.entity.Placement;
import com.rakshitpatel.esd_erp_project.entity.PlacementDomain;
import com.rakshitpatel.esd_erp_project.mapper.PlacementMapper;
import com.rakshitpatel.esd_erp_project.repo.PlacementDomainRepo;
import com.rakshitpatel.esd_erp_project.repo.PlacementRepo;
import com.rakshitpatel.esd_erp_project.repo.PlacementSpecialisationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlacementService {

    @Autowired
    private PlacementMapper placementMapper;

    @Autowired
    private PlacementRepo placementRepo;

    @Autowired
    private PlacementDomainRepo placementDomainRepo;

    @Autowired
    private PlacementSpecialisationRepo placementSpecialisationRepo;

    public String addPlacementOffer(PlacementRequest req){
        Placement placement = placementMapper.toPlacement(req);

        placementRepo.save(placement);

        placementDomainRepo.saveAll(placement.getDomains());

        placementSpecialisationRepo.saveAll(placement.getSpecialisations());

        return "Offer added successfully";
    }

}
