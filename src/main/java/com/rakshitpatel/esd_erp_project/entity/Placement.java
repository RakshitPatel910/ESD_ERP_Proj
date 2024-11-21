package com.rakshitpatel.esd_erp_project.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Placement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "organisation_id", nullable = false)
    private Long organisationId;


    private String profile;

    private String description;

    private Double minGrade;

    private Integer intake;

    @OneToMany(mappedBy = "placement", cascade = CascadeType.ALL)
    private List<PlacementDomain> domains = new ArrayList<>();

    @OneToMany(mappedBy = "placement", cascade = CascadeType.ALL)
    private List<PlacementSpecialisation> specialisations = new ArrayList<>();
}
