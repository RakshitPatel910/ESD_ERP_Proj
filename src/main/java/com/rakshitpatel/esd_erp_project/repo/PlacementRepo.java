package com.rakshitpatel.esd_erp_project.repo;

import com.rakshitpatel.esd_erp_project.entity.Placement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacementRepo extends JpaRepository<Placement, Long> {
}
