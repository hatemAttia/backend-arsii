package com.example.backendarsii.repository;

import com.example.backendarsii.entity.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpportunityRepository extends JpaRepository<Opportunity,Long> {
}
