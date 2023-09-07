package com.example.backendarsii.entity;


import com.example.backendarsii.dto.enumData.TypeEvent;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event")
@SQLDelete(sql = "UPDATE event SET deleted = true WHERE id=?")
@Where(clause = "deleted = false ")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Date date;
    private String former;
    private String URLImage;
    private int numberOfParticipants;
    private String location;
    private boolean status;
    @Enumerated(EnumType.STRING)
    private TypeEvent typeEvent;
    @CreationTimestamp
    private Instant createdAt;
    @CreationTimestamp
    private Instant updatedAt;
    private boolean deleted = Boolean.FALSE;

  /*  @OneToMany(mappedBy = "event")
    private List<UserEvent> userEvents = new ArrayList<>();*/


    /*public boolean isEventPast() {
        return date != null && date.before(new Date());
    }
    public boolean isEventFuture() {
        return date != null && date.after(new Date());
    }

    public boolean isEventInProgress() {
        Date now = new Date();
        return date != null && date.before(now) && date.after(new Date(now.getTime() - 3600000));
    }*/
    public boolean isActive()
    {
        return status;
    }
}







