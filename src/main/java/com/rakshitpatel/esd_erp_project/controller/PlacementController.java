package com.rakshitpatel.esd_erp_project.controller;

import com.rakshitpatel.esd_erp_project.dto.PlacementRequest;
import com.rakshitpatel.esd_erp_project.service.PlacementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("placement")
@RequiredArgsConstructor
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    @PostMapping
    public ResponseEntity<String> addPlacementOffer(@RequestHeader("Authorization") String token, @RequestBody @Valid PlacementRequest req){
        return ResponseEntity.ok(placementService.addPlacementOffer(req, token));
    }
}
