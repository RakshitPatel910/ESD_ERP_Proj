package com.rakshitpatel.esd_erp_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "placement")
public class Placement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "organisation_id", nullable = false)
    private Long organisationId;

    @Column(name = "profile")
    private String profile;

    @Column(name = "description")
    private String description;

    @Column(name = "min_grade", columnDefinition = "DECIMAL(10, 2)")
    private Double minGrade;

    @Column(name = "intake")
    private Integer intake;

    @OneToMany(mappedBy = "placement", cascade = CascadeType.ALL)
    private List<PlacementDomain> domains = new ArrayList<>();

    @OneToMany(mappedBy = "placement", cascade = CascadeType.ALL)
    private List<PlacementSpecialisation> specialisations = new ArrayList<>();
}
