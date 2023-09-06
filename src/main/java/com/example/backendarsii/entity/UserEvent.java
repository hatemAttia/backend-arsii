package com.example.backendarsii.entity;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@RequiredArgsConstructor
public class UserEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private Date date;
}
