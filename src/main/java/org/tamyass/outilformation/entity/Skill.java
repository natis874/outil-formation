package org.tamyass.outilformation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "skills")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id" )
    private Category category;
    @Min(1) @Max(5)
    private Integer selfLevel;
    @Min(1) @Max(5)
    private Integer AiLevel;
    @ManyToOne
    @JoinColumn(name = "user_id" ) // Crée la colonne user_id dans la table skill
    private User user;
    @OneToMany(mappedBy = "skill")
    private List<AssessmentQuestion> questionList = new ArrayList<>();

}
