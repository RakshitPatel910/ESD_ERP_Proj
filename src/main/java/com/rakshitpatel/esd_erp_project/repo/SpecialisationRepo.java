package com.rakshitpatel.esd_erp_project.repo;

import com.rakshitpatel.esd_erp_project.entity.Specialisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialisationRepo extends JpaRepository<Specialisation, Long> {
    List<Specialisation> findAllById(List<Long> ids);
}
