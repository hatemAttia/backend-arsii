package com.example.backendarsii.repository;

import com.example.backendarsii.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PartnerRepository extends JpaRepository<Partner,Long> {
    @Query("SELECT p FROM Partner p")
    List<Partner> findAllPartners();
    Optional<Partner> findById(Long id);
    void deleteById(Long id);
   // Partner save(Partner existingPartner);
}
