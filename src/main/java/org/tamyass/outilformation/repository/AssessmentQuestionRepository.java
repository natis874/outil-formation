package org.tamyass.outilformation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tamyass.outilformation.entity.AssessmentQuestion;
import org.tamyass.outilformation.entity.Category;

public interface AssessmentQuestionRepository extends JpaRepository<AssessmentQuestion,Long> {
}
