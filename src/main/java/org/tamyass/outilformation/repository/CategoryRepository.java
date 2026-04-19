package org.tamyass.outilformation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tamyass.outilformation.entities.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
