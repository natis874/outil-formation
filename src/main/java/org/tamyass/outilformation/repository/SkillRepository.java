package org.tamyass.outilformation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tamyass.outilformation.entities.Skill;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Long> {

    List<Skill> findByUserId(Long userId);
    List<Skill> findByCategoryId(Long categoryId);

}
