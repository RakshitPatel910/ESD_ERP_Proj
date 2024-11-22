package com.rakshitpatel.esd_erp_project.repo;

import com.rakshitpatel.esd_erp_project.entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Iterator;
import java.util.List;

public interface DomainRepo extends JpaRepository<Domain, Long> {
    List<Domain> findAllById(Iterator<Long> ids);
}
