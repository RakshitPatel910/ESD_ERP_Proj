package com.rakshitpatel.esd_erp_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "placement_specialisation")
public class PlacementSpecialisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "placement_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Placement placement;

    @ManyToOne
    @JoinColumn(name = "specialisation_id", nullable = false)
    private Specialisation specialisation;
}
