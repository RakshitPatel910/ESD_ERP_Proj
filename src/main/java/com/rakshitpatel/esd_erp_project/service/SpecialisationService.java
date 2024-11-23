package com.rakshitpatel.esd_erp_project.service;

import com.rakshitpatel.esd_erp_project.entity.Specialisation;
import com.rakshitpatel.esd_erp_project.repo.SpecialisationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialisationService {

    private final SpecialisationRepo specialisationRepo;

    public List<Specialisation> getAllSpecialisation(){
        return specialisationRepo.findAll();
    }
}
