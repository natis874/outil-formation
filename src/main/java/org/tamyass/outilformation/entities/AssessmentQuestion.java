package org.tamyass.outilformation.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "assessmentQuestions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AssessmentQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String enonce;
    @Column
    private String questionText;
    @Column
    private String answerText;
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;


}
