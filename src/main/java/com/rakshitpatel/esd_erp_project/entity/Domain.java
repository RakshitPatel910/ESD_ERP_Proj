package com.rakshitpatel.esd_erp_project.entity;

import jakarta.persistence.*;

@Entity
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

//    etc..
}
