package com.example.backendarsii.repository;

import com.example.backendarsii.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Long> {

    List<Contact> findAllByUserId(Long id);

}
