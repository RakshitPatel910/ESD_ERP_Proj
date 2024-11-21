package com.rakshitpatel.esd_erp_project.entity;

import jakarta.persistence.*;

@Entity
public class Specialisation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "cred_required")
    private Double credit_required;
}
