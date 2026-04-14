package org.tamyass.outilformation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tamyass.outilformation.entities.Skill;

public interface SkillRepository extends JpaRepository<Skill,Long> {
}
