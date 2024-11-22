package com.rakshitpatel.esd_erp_project.entity;

import jakarta.persistence.*;

@Entity
public class PlacementSpecialisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "placement_id", nullable = false)
    private Placement placement;

    @ManyToOne
    @JoinColumn(name = "specialisation_id", nullable = false)
    private Specialisation specialisation;
}