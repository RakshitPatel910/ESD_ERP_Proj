use academic_erp;

alter table placement
    add constraint fk_placement_organisation
        foreign key (organisation_id)
            references organisation(id)
            on delete cascade;

alter table placement_domain
    add constraint fk_placement_domain_placement
        foreign key (placement_id)
            references placement(id)
            on delete cascade;

alter table placement_domain
    add constraint fk_placement_domain_domain
        foreign key (domain_id)
            references domain(id)
            on delete cascade;

alter table placement_specialisation
    add constraint fk_placement_specialisation_placement
        foreign key (placement_id)
            references placement(id)
            on delete cascade;

alter table placement_specialisation
    add constraint fk_placement_specialisation_specialisation
        foreign key (specialisation_id)
            references specialisation(id)
            on delete cascade;
