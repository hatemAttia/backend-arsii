package com.example.backendarsii.repository;

import com.example.backendarsii.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner,Long> {

    boolean existsByName(String name);
}
