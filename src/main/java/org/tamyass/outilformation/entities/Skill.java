package org.tamyass.outilformation.entities;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id" )
    private Category category;
    @Min(1) @Max(5)
    private Integer selfLevel;
    @Min(1) @Max(5)
    private Integer aiLevel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" ) // Crée la colonne user_id dans la table skill
    private User user;
    @OneToMany(mappedBy = "skill")
    private List<AssessmentQuestion> questions = new ArrayList<>();


        /*
✅ EAGER (chargement immédiat)
➡️ Quand tu charges une entité, les relations marquées EAGER sont chargées tout de suite,
 dans la même opération (souvent via des requêtes supplémentaires ou un join selon Hibernate).

Exemple : tu fais userRepository.findById(1)
Si skills était EAGER, Hibernate va aussi charger les skills immédiatement.

✅ LAZY (chargement à la demande)
➡️ Quand tu charges l’entité, la relation n’est pas chargée tout de suite.
Elle sera chargée uniquement si tu y accèdes.

Exemple : tu fais findById(1)
Les skills ne sont pas chargés tant que tu ne fais pas user.getSkills().
     */
}
