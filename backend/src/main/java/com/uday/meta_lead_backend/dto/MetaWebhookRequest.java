package com.uday.meta_lead_backend.dto;

import java.util.List;

import lombok.Data;
@Data 
public class MetaWebhookRequest {
    private List<Entry> entry;
    private String object;

 }