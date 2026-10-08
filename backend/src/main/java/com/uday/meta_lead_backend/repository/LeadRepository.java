package com.uday.meta_lead_backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uday.meta_lead_backend.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

    Optional<Lead> findByMetaLeadId(String metaLeadId);

    List<Lead> findAllByOrderByCreatedAtDesc();

    boolean existsByMetaLeadId(String metaLeadId);
}