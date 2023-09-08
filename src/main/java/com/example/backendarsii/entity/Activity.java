package com.example.backendarsii.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.Instant;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="activity")
@SQLDelete(sql = "UPDATE activity SET deleted = true WHERE id=?")
@Where(clause = "deleted = false ")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String title;
    private String description;
    private String typeActivity;
    private String URLImage;
    @CreationTimestamp
    private Instant createdAt;
    @CreationTimestamp
    private Instant updatedAt;
    private boolean deleted = Boolean.FALSE;
}
