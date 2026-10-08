package com.uday.meta_lead_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data 
public class Value {
   @JsonProperty("leadgen_id")
private String leadgenId;

@JsonProperty("page_id")
private String pageId;

@JsonProperty("form_id")
private String formId;

@JsonProperty("ad_id")
private String adId;

@JsonProperty("adgroup_id")
private String adgroupId;
}
