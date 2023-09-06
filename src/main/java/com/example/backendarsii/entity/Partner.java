package com.example.backendarsii.entity;





import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "partner")
@SQLDelete(sql = "UPDATE partner SET deleted = true WHERE id=?")
@Where(clause = "deleted = false ")
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String adress;
    private String type;
    private String contact;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private boolean deleted = Boolean.FALSE;
}
