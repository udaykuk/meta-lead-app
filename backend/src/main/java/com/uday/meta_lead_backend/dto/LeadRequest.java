package com.uday.meta_lead_backend.dto;

import jakarta.validation.constraints.NotBlank;

public record LeadRequest(
        @NotBlank String metaLeadId,
        String name,
        String email,
        String phone
) {
}