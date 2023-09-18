package com.example.backendarsii.repository;

import com.example.backendarsii.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(value = "SELECT E from Event E where E.status=true  ")
    List<Event> findAllEvent();

    @Query(value = "SELECT E from Event E where E.status=false ")
    List<Event> findAllSuggestEvent();

}
