package com.app.TechHive.web;

import com.app.TechHive.domain.DTOs.ResourceResponse;
import com.app.TechHive.domain.DTOs.UserRequest;
import com.app.TechHive.domain.services.AI_service;
import com.app.TechHive.domain.services.ResponseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {
    private ResponseService responseService;

    public RecommendationController( ResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping("/models")
    public ResponseEntity<String> getModels() {
        return ResponseEntity.ok(responseService.getModels());
    }

    @PostMapping("/promptTest")
    public ResponseEntity<ResourceResponse> getPromptTest(@Valid @RequestBody UserRequest request) throws JsonProcessingException {
        return ResponseEntity.ok(responseService.getResources(request));
    }
}
