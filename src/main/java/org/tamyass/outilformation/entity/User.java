package org.tamyass.outilformation.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nom;
    @Column
    private String email;
    @Column
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Skill> skills = new ArrayList<>();
}
