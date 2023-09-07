package com.example.backendarsii.repository;

import com.example.backendarsii.entity.Partner;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PartnerRepository extends JpaRepository<Partner,Long> {
    @Query("SELECT p FROM Partner p")
    List<Partner> findAllPartners();


    @NotNull Optional<Partner> findById(Integer id);
    void deleteById(Integer id);
   // Partner save(Partner existingPartner);
}
