package com.example.backendarsii.repository;

import com.example.backendarsii.entity.Event;
import com.example.backendarsii.entity.User;
import com.example.backendarsii.entity.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserEventRepository extends JpaRepository<UserEvent, Long> {

    List<UserEvent> findAllByUserId(Long id);

    List<UserEvent> findAllByEventId(Long id);

    @Query("SELECT CASE WHEN COUNT(ue) > 0 THEN true ELSE false END FROM UserEvent ue WHERE ue.user = ?1 AND ue.event = ?2")
    Boolean CheckJoinedEvent(User userId, Event eventId);

}
