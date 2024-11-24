package com.rakshitpatel.esd_erp_project.service;

import com.rakshitpatel.esd_erp_project.entity.Domain;
import com.rakshitpatel.esd_erp_project.repo.DomainRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainService {

    private final DomainRepo domainRepo;

    public List<Domain> getAllDomain(){
        System.out.println(domainRepo.findAll());
        return domainRepo.findAll();
    }

}
