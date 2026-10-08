package com.uday.meta_lead_backend.dto;

import java.util.List;

import lombok.Data;
@Data 
public class Entry {

    private String id;
    private long time;
    private List<Change> changes;
}