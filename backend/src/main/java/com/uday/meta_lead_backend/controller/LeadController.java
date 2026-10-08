package com.uday.meta_lead_backend.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.uday.meta_lead_backend.dto.LeadRequest;
import com.uday.meta_lead_backend.dto.LeadResponse;
import com.uday.meta_lead_backend.entity.Lead;
import com.uday.meta_lead_backend.service.LeadService;
import com.uday.meta_lead_backend.sse.LeadStreamService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/leads")
@RequiredArgsConstructor
public class LeadController {

    private final LeadService leadService;
    private final LeadStreamService streamService;

    @PostMapping
    public ResponseEntity<Void> createLead(
            @Valid @RequestBody LeadRequest request) {

        Lead lead = new Lead();

        lead.setMetaLeadId(request.metaLeadId());
        lead.setName(request.name());
        lead.setEmail(request.email());
        lead.setPhone(request.phone());

        leadService.saveLead(lead)
                .ifPresent(savedLead ->
                        streamService.broadcast(
                                LeadResponse.from(savedLead)
                        )
                );

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<LeadResponse>> getLeads() {

        return ResponseEntity.ok(
                leadService.getAllLeads()
                        .stream()
                        .map(LeadResponse::from)
                        .toList()
        );
    }

    @GetMapping(
            value = "/stream",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )
    public SseEmitter streamLeads() {
        return streamService.subscribe();
    }
}