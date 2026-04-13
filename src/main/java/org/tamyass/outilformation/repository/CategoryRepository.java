package org.tamyass.outilformation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tamyass.outilformation.entity.Category;
import org.tamyass.outilformation.entity.Skill;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
