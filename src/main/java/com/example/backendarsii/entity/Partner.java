package com.example.backendarsii.entity;





import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="partner")
@SQLDelete(sql = "UPDATE partner SET deleted = true WHERE id=?")
@Where(clause = "deleted = false ")
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="bank_id")
   // private int bankId;
    private Integer id;
    @Column(name="NAME", unique = true)

    private String name;
    private String address;
    private String type;
    private String contact;
    private String description;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
    private boolean deleted = Boolean.FALSE;
}
