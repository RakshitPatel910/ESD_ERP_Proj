package com.rakshitpatel.esd_erp_project.repo;

import com.rakshitpatel.esd_erp_project.entity.PlacementSpecialisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacementSpecialisationRepo extends JpaRepository<PlacementSpecialisation, Long> {
}
