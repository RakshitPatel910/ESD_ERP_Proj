package com.rakshitpatel.esd_erp_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PlacementDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "placement_id", nullable = false)
    private Placement placement;

    @ManyToOne
    @JoinColumn(name = "domain_id", nullable = false)
    private Domain domain;
}
