package com.rakshitpatel.esd_erp_project.controller;

import com.rakshitpatel.esd_erp_project.dto.PlacementRequest;
import com.rakshitpatel.esd_erp_project.service.PlacementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("placement")
@RequiredArgsConstructor
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    @PostMapping
    public ResponseEntity<String> addPlacementOffer(@RequestBody @Valid PlacementRequest req){
        return ResponseEntity.ok(placementService.addPlacementOffer(req));
    }
}
