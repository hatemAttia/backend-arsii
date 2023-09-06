package com.example.backendarsii.entity;


import com.example.backendarsii.dto.enumData.TypeEvent;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@Entity
@Table(name = "event")
@SQLDelete(sql = "UPDATE event SET deleted = true WHERE id=?")
@Where(clause = "deleted = false ")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
    private Date createdAt;
    private Date updatedAt;
    private boolean deleted = Boolean.FALSE;

   /* @OneToMany(mappedBy = "event")
    private List<UserEvent> userEvents = new ArrayList<>();*/

    public Event(Long id, String title, String description, Date date, String former, String urlImage, int numberOfParticipants, String location, boolean status, TypeEvent typeEvent, Date createdAt, Date updatedAt, boolean deleted) {
    }


    public boolean isEventPast() {
        return date != null && date.before(new Date());
    }

    public boolean isEventFuture() {
        return date != null && date.after(new Date());
    }

    public boolean isEventInProgress() {
        Date now = new Date();
        return date != null && date.before(now) && date.after(new Date(now.getTime() - 3600000));
    }
    public boolean isActive()
    {
        return status;
    }
}







