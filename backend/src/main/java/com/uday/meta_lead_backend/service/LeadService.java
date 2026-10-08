package com.uday.meta_lead_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.uday.meta_lead_backend.entity.Lead;
import com.uday.meta_lead_backend.repository.LeadRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class LeadService {

    private final LeadRepository leadRepository;

    public Optional<Lead> saveLead(Lead lead) {

        if (lead.getName() == null || lead.getName().isBlank()) {
            lead.setName("Unknown");
        }

        if (leadRepository.existsByMetaLeadId(lead.getMetaLeadId())) {
            return Optional.empty();
        }

        try {
            return Optional.of(leadRepository.save(lead));
        } catch (DataIntegrityViolationException e) {
            log.warn(
                    "Lead not saved (duplicate or invalid): {}",
                    lead.getMetaLeadId(),
                    e
            );

            return Optional.empty();
        }
    }

    public List<Lead> getAllLeads() {
        return leadRepository.findAllByOrderByCreatedAtDesc();
    }
}