package com.example.pratyush.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private Long user_id;

    @Column(name="first_name",nullable = false)
    private String first_name;

    @Column(name="middle_name")
    private String middle_name;

    @Column(name="last_name",nullable = false)
    private String last_name;

    @Column(name="password")
    private String password;

    @Column(name="email",nullable = false)
    private String email;

    @Column(name="phone",nullable = false)
    private String phone;

    @Column(name="organization")
    private final String org="FREO";

    //Audit columns
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by", nullable = false)
    private final String createdBy="Pratyush";

    @UpdateTimestamp
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Column(name = "modified_by")
    private final String modifiedBy="Pratyush";

    @ManyToMany
    @JoinTable(
            name="user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    Set<Role> assignedRoles=new HashSet<>();
}
