package org.tamyass.outilformation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tamyass.outilformation.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
