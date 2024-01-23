package com.example.pratyush.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="org_id")
    private Long org_id;
}
