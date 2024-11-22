package com.rakshitpatel.esd_erp_project.repo;

import com.rakshitpatel.esd_erp_project.entity.PlacementDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacementDomainRepo extends JpaRepository<PlacementDomain, Long> {
}
