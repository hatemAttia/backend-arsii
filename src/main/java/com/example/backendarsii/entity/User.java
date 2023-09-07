package com.example.backendarsii.entity;


import com.example.backendarsii.dto.enumData.Gender;
import com.example.backendarsii.dto.enumData.Office;
import com.example.backendarsii.dto.enumData.Post;
import com.example.backendarsii.dto.enumData.Role;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@SQLDelete(sql = "UPDATE user SET deleted = true WHERE id=?")
@Where(clause = "deleted = false ")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phoneNumber;
    private String region;
    private String job;
    private String universityOrCompany;
    @Enumerated(EnumType.STRING)
    private Post post;
    @Enumerated(EnumType.STRING)
    private Office office;
    private String image;
    @CreationTimestamp
    private Instant expiresAt;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean deleted = Boolean.FALSE;
    @OneToMany(mappedBy = "user")
    private List<UserEvent> userEvents = new ArrayList<>();
    public User(Long id, String firstName, String lastName, String userName, String email, String password, Gender gender, String phoneNumber, String region, String job, String universityOrCompany, Post post, Office office, String image, Instant expiresAt, Instant createdAt, Role role, boolean deleted) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.region = region;
        this.job = job;
        this.universityOrCompany = universityOrCompany;
        this.post = post;
        this.office = office;
        this.image = image;
        this.expiresAt = expiresAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role = role;
        this.deleted = deleted;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        if (role == Role.MEMBER){
        // return true if today < expires_at
        return expiresAt.isAfter(Instant.now());
        }
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
