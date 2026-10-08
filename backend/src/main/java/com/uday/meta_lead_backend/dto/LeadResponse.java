package com.uday.meta_lead_backend.dto;

import java.time.LocalDateTime;

import com.uday.meta_lead_backend.entity.Lead;

public record LeadResponse(
        Long id,
        String metaLeadId,
        String name,
        String email,
        String phone,
        LocalDateTime createdAt
) {

    public static LeadResponse from(Lead lead) {
        return new LeadResponse(
                lead.getId(),
                lead.getMetaLeadId(),
                lead.getName(),
                lead.getEmail(),
                lead.getPhone(),
                lead.getCreatedAt()
        );
    }
}